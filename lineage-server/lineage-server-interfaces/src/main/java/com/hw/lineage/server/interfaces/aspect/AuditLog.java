package com.hw.lineage.server.interfaces.aspect;


import com.hw.lineage.common.enums.audit.ModuleCode;
import com.hw.lineage.common.enums.audit.OperationType;

import java.lang.annotation.*;

/**
 * @description: AuditLog
 * @author: HamaWhite
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuditLog {

    ModuleCode module();

    OperationType type();

    String descr() default "";

    /**
     * Do you need to record method parameters
     */
    boolean params() default true;
}
