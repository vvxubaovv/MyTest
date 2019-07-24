package com.xubao.test.simpleTest.executorTest.threadBindTest;

import com.xubao.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ThreadBindExecutorTest
{
	public static void main(String[] args) throws IOException
	{
		ThreadBindExecutor executor = new ThreadBindExecutor();
		executor.register("test0");
		executor.register("test1");
		executor.register("test2");

		for(int i = 0; i < 100000; i++)
		{
			int x = i;
			executor.execute(new ThreadBindExecutor.BindRunnable("test" + (i % 3))
			{
				@Override
				public void run()
				{
					try
					{
						TimeUnit.MILLISECONDS.sleep(200);
						Log.log("thread name:{} this:{}", Thread.currentThread().getName(), x);
					}
					catch(Exception e)
					{

					}
				}
			});
		}

		System.in.read();
	}
}
