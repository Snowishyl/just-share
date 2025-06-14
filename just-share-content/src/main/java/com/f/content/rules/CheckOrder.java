package com.f.content.rules;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)//用户运行时可以反射访问
public @interface CheckOrder {
    /**
     * 检查的顺序
     */
    int value() default 0;
}
