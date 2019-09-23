package com.xubao.test.simpleTest.threadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class InterruptTest
{
	public static void main(String[] args) throws InterruptedException
	{
		System.out.println("before");
//		test();
		System.out.println("after");

		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.submit(() -> {
			System.out.println("before");
			Thread.currentThread().interrupt();
			System.out.println(Thread.currentThread().isInterrupted());//运行完一个任务后会清除中断状态
			Thread.currentThread().interrupt();
			System.out.println("after");
		});

		TimeUnit.SECONDS.sleep(2);
		executorService.submit(() -> {
			System.out.println("before");
			try
			{
				System.out.println(Thread.currentThread().isInterrupted());
				Thread.currentThread().interrupt();
				Thread.currentThread().sleep(1000);
				System.out.println(Thread.currentThread().isInterrupted());
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println("after");
		});
		TimeUnit.SECONDS.sleep(2);

	}

	private static void test()
	{
		while(true)
		{
			System.out.println("before");
			Thread.currentThread().interrupt();
			System.out.println("after");
		}
	}

	private static void test1()
	{

	}
}
