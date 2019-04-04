package com.xubao.test.simpleTest.springTest.aopTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/4/2
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface ForArgs
{
}
