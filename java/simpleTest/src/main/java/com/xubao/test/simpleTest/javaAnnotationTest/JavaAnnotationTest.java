package com.xubao.test.simpleTest.javaAnnotationTest;

import java.lang.annotation.Native;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/5/26
 */
public class JavaAnnotationTest
{
	@Native
	public int a = -85;


	public static void main(String[] args)
	{
		JavaAnnotationTest j = new JavaAnnotationTest();
		System.out.println(j.a);
	}
}
