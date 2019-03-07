package com.xubao.test.simpleTest.threadTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/2/22
 */
public class ThreadTest3
{
	public static List<String> list = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8"));

	public static void main(String[] args)
	{
		Object o1 = new Object();

		int sleep = 10 * 1000;
		Runnable runnable = new Runnable()
		{
			@Override
			public void run()
			{

				for(String str : list)
				{
					synchronized(o1)
					{
						try
						{
							System.out.println(Thread.currentThread().getName() + str);
							TimeUnit.SECONDS.sleep(10);
							o1.wait();
						}
						catch(InterruptedException e)
						{
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + " " + str);
					}
				}
			}
		};

		Thread t1 = new Thread(runnable, "t1");
		Thread t2 = new Thread(runnable, "t2");
//		Thread t3 = new Thread(runnable, "t3");
//		Thread t4 = new Thread(runnable, "t4");
//		Thread t5 = new Thread(runnable, "t5");
//		Thread t6 = new Thread(runnable, "t6");

		t1.start();
		t2.start();
//		t3.start();
//		t4.start();
//		t5.start();
//		t6.start();

		Thread tt = new Thread(new Runnable()
		{
			@Override
			public void run()
			{

				for(int i = 0; i < list.size(); i++)
				{
					try
					{
						TimeUnit.SECONDS.sleep(1);
						System.out.println(i + "ffffffffff");
						synchronized(o1)
						{
							o1.notifyAll();
						}

					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
		});
		tt.start();
	}
}
