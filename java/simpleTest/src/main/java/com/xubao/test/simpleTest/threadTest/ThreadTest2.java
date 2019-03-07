package com.xubao.test.simpleTest.threadTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/11/27
 */
public class ThreadTest2
{
	public static List<String> list = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8"));

	public static void main(String[] args) throws IOException
	{
		int sleep = 10 * 1000;
		Runnable runnable = new Runnable()
		{
			@Override
			public void run()
			{
				for(String str : list)
				{
					try
					{
						Thread.sleep(sleep);
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + " " + str);
				}
			}
		};

		Thread t1 = new Thread(runnable, "t1");
		Thread t2 = new Thread(runnable, "t2");
		Thread t3 = new Thread(runnable, "t3");
		Thread t4 = new Thread(runnable, "t4");
		Thread t5 = new Thread(runnable, "t5");
		Thread t6 = new Thread(runnable, "t6");
		
		t1.setDaemon(true);
		t2.setDaemon(true);
		t3.setDaemon(true);
		t4.setDaemon(true);
		t5.setDaemon(true);
		t6.setDaemon(true);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();


		System.out.println("start over ...................");
		System.in.read();

	}
}
