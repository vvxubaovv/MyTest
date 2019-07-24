package com.xubao.test.simpleTest.executorTest;

import com.xubao.Log;

import java.util.concurrent.*;

public class SimpleTest
{
	public static void main(String[] args) throws ExecutionException, InterruptedException
	{
		ExecutorService service = Executors.newSingleThreadExecutor();
		TaskListener listener = new TaskListener()
		{
			@Override
			public void taskStart() throws Exception
			{
				System.out.println("taskStart");
			}

			@Override
			public void taskFinish() throws Exception
			{
				System.out.println("taskFinish");
			}
		};
		Future<String> future = service.submit(new Callable<String>()
		{
			@Override
			public String call() throws Exception
			{
				try
				{
					listener.taskStart();
				}
				catch(Exception e)
				{
					listenerExceptionHandler(e);
				}

				TimeUnit.SECONDS.sleep(2);

				try
				{
					listener.taskFinish();
				}
				catch(Exception e)
				{
					listenerExceptionHandler(e);
				}
				return "finish";
			}

			void listenerExceptionHandler(Exception e)
			{
				Log.log("e:{}", e);
			}
		});

		String s = future.get();
		Log.log("result:{}", s);
	}

	private static interface TaskListener
	{
		void taskStart() throws Exception;

		void taskFinish() throws Exception;
	}
}
