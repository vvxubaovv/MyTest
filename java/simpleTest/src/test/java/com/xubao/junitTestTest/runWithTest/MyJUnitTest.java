package com.xubao.junitTestTest.runWithTest;

import com.xubao.junitTestTest.MyIgnore;
import com.xubao.junitTestTest.MyJUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MyJUnitRunner.class)
@MyIgnore(tag = {"a","b"})
public class MyJUnitTest
{
	@Test
	@MyIgnore(tag = "a")
	public void test1()
	{
		System.out.println("test1");
	}

	@Test
	@MyIgnore(tag = "a")
	public void test2()
	{
		System.out.println("test2");
	}
}
