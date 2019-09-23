package com.xubao.junitperfTest;

import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.JUnitPerfTestRequirement;
import org.junit.Rule;
import org.junit.Test;

public class SimpleTest
{
	@Rule
	public JUnitPerfRule perfTestRule = new JUnitPerfRule();

	@Test
	@JUnitPerfTest(durationMs = 10_000, maxExecutionsPerSecond = 1)
	@JUnitPerfTestRequirement(executionsPerSec = 2)
	public void helloTest() throws InterruptedException
	{
		Thread.sleep(200);
		System.out.println("just print");
	}

	@Test(timeout = 20)
	public void test() throws InterruptedException
	{
		Thread.sleep(100);
	}
}
