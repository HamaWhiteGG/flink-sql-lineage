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

package com.hw.lineage.server.interfaces.exception;

import com.hw.lineage.common.exception.LineageException;
import com.hw.lineage.server.interfaces.result.Result;
import com.hw.lineage.server.interfaces.result.ResultCode;
import com.hw.lineage.server.interfaces.result.ResultMessage;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * refers to @see <a href="https://github.com/apache/shenyu">https://github.com/apache/shenyu</a>. thanks
 *
 * @description: ExceptionHandlers
 * @author: HamaWhite
 */
@ResponseBody
@ControllerAdvice
public class ExceptionHandlers {

    private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandlers.class);

    @ExceptionHandler(Exception.class)
    protected Result<Boolean> handleExceptionHandler(final Exception e) {
        LOG.error(e.getMessage(), e);
        String message = e instanceof LineageException
                ? e.getMessage()
                : String.format("%s%sCaused by: %s", e.getMessage(), System.lineSeparator(),
                        ExceptionUtils.getRootCauseMessage(e));
        return Result.error(message);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    protected Result<Boolean> handleIllegalArgumentException(final IllegalArgumentException e) {
        LOG.error("illegal argument exception", e);
        return Result.error(e.getMessage());
    }

    @ExceptionHandler(DuplicateKeyException.class)
    protected Result<Boolean> handleDuplicateKeyException(final DuplicateKeyException e) {
        LOG.error("duplicate key exception ", e);
        return Result.error(ResultMessage.UNIQUE_INDEX_CONFLICT_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    protected Result<Boolean> handleNullPointException(final NullPointerException e) {
        LOG.error("null pointer exception ", e);
        return Result.error(ResultCode.NOT_FOUND_EXCEPTION, ResultMessage.NULL_POINTER_EXCEPTION);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected Result<Boolean> handleHttpRequestMethodNotSupportedException(
            final HttpRequestMethodNotSupportedException e) {
        LOG.warn("http request method not supported", e);
        StringBuilder sb = new StringBuilder();
        sb.append(e.getMethod());
        sb.append(
                " method is not supported for this request. Supported methods are ");
        Objects.requireNonNull(e.getSupportedHttpMethods()).forEach(t -> sb.append(t).append(" "));
        return Result.error(sb.toString());
    }

    /**
     * Thrown after the request entity verification fails in the Get request using @Valid to verify the path
     */
    @ExceptionHandler(BindException.class)
    public Result<Boolean> handleBindExceptionHandler(BindException e) {
        LOG.warn("bind exception", e);
        BindingResult bindingResult = e.getBindingResult();
        String errorMsg = bindingResult.getFieldErrors().stream()
                .map(f -> f.getField().concat(": ").concat(Optional.ofNullable(f.getDefaultMessage()).orElse("")))
                .collect(Collectors.joining("| "));
        return Result.error(errorMsg);
    }

    /**
     * Thrown after @Valid failure on @RequestBody is MethodArgumentNotValidException
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected Result<Boolean> handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        LOG.warn("method argument not valid", e);
        BindingResult bindingResult = e.getBindingResult();
        String errorMsg = bindingResult.getFieldErrors().stream()
                .map(f -> f.getField().concat(": ").concat(Optional.ofNullable(f.getDefaultMessage()).orElse("")))
                .collect(Collectors.joining("| "));
        return Result.error(errorMsg);
    }

    /**
     * Thrown after @Valid failure on @RequestParam is ConstraintViolationException
     */
    @ExceptionHandler(ConstraintViolationException.class)
    protected Result<Boolean> handleConstraintViolationException(final ConstraintViolationException e) {
        LOG.warn("constraint violation exception", e);
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        return Result.error(violations.stream()
                .map(v -> v.getPropertyPath().toString().concat(": ").concat(v.getMessage()))
                .collect(Collectors.joining("| ")));
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    protected Result<Boolean> handleMissingServletRequestParameterException(
            final MissingServletRequestParameterException e) {
        LOG.warn("missing servlet request parameter", e);
        return Result.error(String.format("%s parameter is missing", e.getParameterName()));
    }

    @ExceptionHandler(MissingServletRequestPartException.class)
    protected Result<Boolean> handleMissingServletRequestPartException(final MissingServletRequestPartException e) {
        LOG.warn("missing servlet request part", e);
        return Result.error(String.format("%s part is missing", e.getRequestPartName()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected Result<Boolean> handleMethodArgumentTypeMismatchException(final MethodArgumentTypeMismatchException e) {
        LOG.warn("method argument type mismatch", e);
        return Result.error(String.format("%s should be of type %s", e.getName(),
                Objects.requireNonNull(e.getRequiredType()).getName()));
    }
}
