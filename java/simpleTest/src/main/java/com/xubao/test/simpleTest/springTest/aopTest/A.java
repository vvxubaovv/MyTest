package com.xubao.test.simpleTest.springTest.aopTest;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/2/25
 */
public class A
{
	@Tag
	public void printA()
	{
		System.out.println("A");
	}

	@Tag
	public int printA1()
	{
		System.out.println("A1");
		return 0;
	}

	@Tag
	public static void printA2()
	{
		System.out.println("A2");
	}

	@Tag
	public void printA3(int count){
		System.out.println("A3"+" count:"+count);
	}

	@Tag
	public void printA4(int count4){
		System.out.println("A4"+" count:"+count4);
	}

	@Tag
	public void printA5(int count5,int a){
		System.out.println("A5"+" count:"+count5);
	}

	@Tag
	public void printA6(String count){
		System.out.println("A3"+" count:"+count);
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
