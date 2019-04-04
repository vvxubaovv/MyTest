package com.xubao.test.simpleTest.aspectjTest;

import org.aspectj.lang.annotation.Aspect;

import java.awt.*;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/4/3
 */
public class A
{
	//不能增强main方法.....
	public static void main(String[] args)
	{
		System.out.println("A main.....................");
		a1();

		Point point = new Point();
		point.getX();
	}

	public static void a1()
	{
		System.out.println("a1.............");
	}
}
