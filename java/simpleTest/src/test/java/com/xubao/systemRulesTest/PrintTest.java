package com.xubao.systemRulesTest;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class PrintTest
{
	@Rule
	public final SystemOutRule out = new SystemOutRule().enableLog();

	@Test
	public void sysOutTest()
	{
		for(int i = 0; i < 1; i++)
		{
			System.out.println("just print");
		}
		String log = this.out.getLog();
		Assert.assertTrue(log.contains("just print"));
	}

	@Test
	public void xx()
	{
		System.out.println("jijiji");
		String log = this.out.getLog();

		System.out.println("1111" + log);
	}

}
