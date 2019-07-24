package com.xubao.junitTestTest;

import com.xubao.Log;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Simple
{
	@Before
	public void doBefore()
	{
		Log.log("before");
	}

	@After
	public void doAfter()
	{
		Log.log("after");
	}

	@Test(expected=NullPointerException.class)
	public void doTest()
	{
		Log.log("test");
	}
}
