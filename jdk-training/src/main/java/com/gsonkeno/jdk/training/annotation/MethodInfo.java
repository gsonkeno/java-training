package com.gsonkeno.jdk.training.annotation;

import java.lang.annotation.*;

/**
 * Created by gaosong on 2018-03-29
 */
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo{
    String author() default "Pankaj";
    String date();
    int revision() default 1;
    String comments();
}
