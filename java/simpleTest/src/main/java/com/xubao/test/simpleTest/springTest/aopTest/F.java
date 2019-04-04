package com.xubao.test.simpleTest.springTest.aopTest;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/4/3
 */
public class F
{
	private static F INSTANCE = new F();

	public static F instance()
	{
		return INSTANCE;
	}

	public void printF1()
	{
		System.out.println("F1..........");
	}
}
