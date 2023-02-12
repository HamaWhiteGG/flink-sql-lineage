package com.lineage.server.interfaces.aspect;

import java.lang.annotation.*;

/**
 * @description: SkipAspect
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/12 9:55 PM
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SkipAspect {
}
