package com.xubao.test.simpleTest.swaggerTest;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/3/5
 */
public class ApiTest
{
	public String a(int a, int b, String c)
	{
		System.out.println(a + "" + b + "" + c);
		return c;
	}

	public void b(int a)
	{
		System.out.println(a);
	}

	public int c()
	{
		return 2;
	}
}
