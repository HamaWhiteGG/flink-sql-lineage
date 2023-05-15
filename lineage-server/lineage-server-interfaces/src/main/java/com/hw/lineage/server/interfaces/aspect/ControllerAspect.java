/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hw.lineage.server.interfaces.aspect;

import com.alibaba.fastjson2.JSONObject;
import com.hw.lineage.common.enums.audit.OperationStatus;
import com.hw.lineage.server.application.command.audit.CreateAuditCmd;
import com.hw.lineage.server.application.service.AuditService;
import com.hw.lineage.server.application.service.UserService;
import com.hw.lineage.server.interfaces.util.CopyUtils;
import com.hw.lineage.server.interfaces.util.RequestUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.annotation.Nonnull;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @description: ControllerAspect
 * @author: HamaWhite
 */
@Aspect
@Component
public class ControllerAspect implements ApplicationContextAware {
    private static final Logger LOG = LoggerFactory.getLogger(ControllerAspect.class);

    private ApplicationContext applicationContext;

    private final SpelExpressionParser spelExpressionParser = new SpelExpressionParser();

    private final DefaultParameterNameDiscoverer parameterNameDiscoverer = new DefaultParameterNameDiscoverer();

    @Resource
    private UserService userService;
    @Resource
    private AuditService auditService;

    @Resource
    HttpServletRequest request;

    @Override
    public void setApplicationContext(@Nonnull ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Around("execution(* com.hw.lineage.server.interfaces.controller..*.*(..)) ")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getName();
        String method = signature.getDeclaringType().getSimpleName() + "." + methodName;

        Object[] args = joinPoint.getArgs();
        String[] parameterNames = parameterNameDiscoverer.getParameterNames(signature.getMethod());
        JSONObject parameters = new JSONObject();
        if (notSkipLog(signature) && isAuditParams(signature)) {
            if (args != null && parameterNames != null && parameterNames.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    // since parameters may be modified in method, the parameters are deep copied in advance
                    parameters.put(parameterNames[i], CopyUtils.deepClone(args[i]));
                }
            }
            LOG.info("method: {}, parameters: {}", method, parameters);
        }
        CreateAuditCmd command = new CreateAuditCmd();
        command.setMethod(method);
        // measure method execution time
        StopWatch stopWatch = new StopWatch(method);
        Object result = null;
        try {
            stopWatch.start(methodName);
            result = joinPoint.proceed();
            command.setOperationStatus(OperationStatus.SUCCESS);
            return result;
        } catch (Exception e) {
            if (getAuditLog(signature) != null) {
                command.setException(e.toString());
                command.setOperationStatus(OperationStatus.FAILED);
            }
            throw e;
        } finally {
            stopWatch.stop();
            if (notSkipLog(signature)) {
                LOG.info("method: {}, time: {} ms, parameters: {}, result: {}", method, stopWatch.getTotalTimeMillis(), parameters, result);
            }
            if (getAuditLog(signature) != null) {
                command.setDuration(stopWatch.getTotalTimeMillis());
                if (isAuditParams(signature)) {
                    command.setParameters(parameters);
                }
                createAudit(signature, args, command);
            }
        }
    }


    private boolean notSkipLog(MethodSignature signature) {
        return signature.getMethod().getAnnotation(SkipLogAspect.class) == null;
    }

    private boolean isAuditParams(MethodSignature signature) {
        if(getAuditLog(signature)!=null) {
            return getAuditLog(signature).params();
        }
        return false;
    }

    private AuditLog getAuditLog(MethodSignature signature) {
        return signature.getMethod().getAnnotation(AuditLog.class);
    }

    private void createAudit(MethodSignature signature, Object[] args, CreateAuditCmd command) {
        AuditLog auditLog = getAuditLog(signature);
        command.setUserId(userService.getCurrentUserId());
        command.setModuleCode(auditLog.module())
                .setOperationType(auditLog.type())
                .setIp(RequestUtils.getIpAddr(request))
                .setUsername(userService.getCurrentUsername());

        String[] parameterNames = parameterNameDiscoverer.getParameterNames(signature.getMethod());
        // use Spring Expression Language (SpEL) to calculate the value of descr
        if (args != null && parameterNames != null && parameterNames.length > 0) {
            StandardEvaluationContext context = new StandardEvaluationContext();
            context.setBeanResolver(new BeanFactoryResolver(applicationContext));
            for (int i = 0; i < args.length; i++) {
                context.setVariable(parameterNames[i], args[i]);
            }
            // some spel will call the service method, which is not the main business logic, and will not be logged
            try {
                String descr = spelExpressionParser.parseExpression(auditLog.descr()).getValue(context, String.class);

                command.setDescr(descr);
            } catch (Exception e) {
                command.setDescr("Not parsed desc: " + auditLog.descr() + ", because " + e.getMessage());
            }
        }
        // save to database
        auditService.createAudit(command);
    }
}
