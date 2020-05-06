package com.winsion.net.bootstrap.core.jpa;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(DruidAutoConfiguration.class)
@Documented
public @interface EnableDruid {
}
