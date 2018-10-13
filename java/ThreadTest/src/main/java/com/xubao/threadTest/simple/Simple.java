package com.xubao.threadTest.simple;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/8/13
 */
public class Simple
{
	public static void main(String[] args)
	{
		ExecutorService executorService = Executors.newCachedThreadPool();
		ExecutorService executorService1 = Executors.newFixedThreadPool(2);
		ExecutorService executorService2 = Executors.newScheduledThreadPool(5);
		ExecutorService executorService3 = Executors.newSingleThreadExecutor();
	}
}
