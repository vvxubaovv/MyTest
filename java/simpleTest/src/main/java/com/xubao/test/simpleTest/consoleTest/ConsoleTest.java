package com.xubao.test.simpleTest.consoleTest;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/1/7
 */
public class ConsoleTest
{
	public static void main(String[] args)
	{
		System.out.println("\033\033");
		System.out.println("\033[41;33m哈哈\033[0m");

		printR(10,30);
		System.out.println("\033[2J");
		System.out.print("\033[0;0H");
		System.out.print("1234");
	}

	public static void printR(int x, int y)
	{
		for(int i = 0; i < x; i++)
		{
			for(int j = 0; j < y; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}
}
