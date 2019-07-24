package com.xubao.junitTestTest.runWithTest;

import com.xubao.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParameterizedTest
{
	private int a;
	private int b;

	@Parameterized.Parameters
	public static Collection<Object[]> prepareData()
	{
		return Arrays.asList(new Object[][] {
				{ 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 }
		});
	}


	public ParameterizedTest(int arg0, int expected)
	{
		this.a = arg0;
		this.b = expected;
	}

//	@Before
//	public void doBefore()
//	{
//		Log.log("before");
//	}
//
//	@After
//	public void doAfter()
//	{
//		Log.log("after");
//	}

	@Test
	public void doTest()
	{
		Log.log("a={},b={}", a, b);
//		Assert.assertEquals(a, b);
	}


//	@Parameterized.Parameters
//	public static Collection<Object[]> data() {
//		return Arrays.asList(new Object[][] {
//				{ 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 }
//		});
//	}
//
//	private int a;
//
//	private int b;
//
//	public ParameterizedTest(int wwinput, int wwexpected) {
//		this.a= wwinput;
//		this.b= wwexpected;
//	}
//
//	@Test
//	public void lptest() {
//		Log.log(a);
//		System.out.println(a);
//		System.out.println(b);
//	}
}
