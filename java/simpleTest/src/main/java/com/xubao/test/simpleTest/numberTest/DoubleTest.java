package com.xubao.test.simpleTest.numberTest;

import com.xubao.Log;

public class DoubleTest
{
	public static void main(String[] args)
	{
		test1();
	}

	private static void test1()
	{
		double d = 8.234354321;
		Log.log("d={}", d);
		Log.log("d%1={}", d % 1);
	}
}
