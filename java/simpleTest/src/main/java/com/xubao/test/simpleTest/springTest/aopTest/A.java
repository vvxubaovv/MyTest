package com.xubao.test.simpleTest.springTest.aopTest;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/2/25
 */
public class A
{
	public void printA()
	{
		System.out.println("A");
	}

	public int printA1()
	{
		System.out.println("A1");
		return 0;
	}

	public static void printA2()
	{
		System.out.println("A2");
	}

	public static class B
	{
		public void printB()
		{
			System.out.println("B");
		}

		public int printB1()
		{
			System.out.println("B1");
			return 0;
		}

		public static void printB2()
		{
			System.out.println("B2");
		}
	}
}
