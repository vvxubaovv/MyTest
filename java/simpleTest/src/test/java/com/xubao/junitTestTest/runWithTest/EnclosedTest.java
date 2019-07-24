package com.xubao.junitTestTest.runWithTest;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)//运行内部静态类(除抽象类)的测试方法 忽略自身测试方法
public class EnclosedTest
{
	@Test
	public void testA()
	{
		System.out.println("EnclosedTest A");
	}

	public class Test1
	{

		@Test
		public void testA()
		{
			System.out.println("Test1 A");
		}

		@Test
		public void testB()
		{
			System.out.println("Test1 B");
		}
	}

	public static class Test2
	{

		@Test
		public void testA()
		{
			System.out.println("Test2 A");
		}

		@Test
		public void testB()
		{
			System.out.println("Test2 B");
		}
	}

	public static abstract class Test3
	{

		@Test
		public void testA()
		{
			System.out.println("Test2 A");
		}

		@Test
		public void testB()
		{
			System.out.println("Test2 B");
		}
	}
}
