package com.xubao.test.simpleTest.executorTest.threadBindTest;

import java.util.*;
import java.util.concurrent.*;

public class ThreadBindExecutor implements Executor
{
	private static String HOLD_KEY = "HOLD_KEY";

	protected Map<String, ExecutorService> executorMap = new ConcurrentHashMap<>();

	protected ThreadFactory factory = new ThreadFactory()
	{
		int index = 0;

		@Override
		public Thread newThread(Runnable r)
		{
			Thread thread = new Thread(r);
			thread.setDaemon(true);
			thread.setName("thread-bind-thread-" + index++);
			return thread;
		}
	};

	@Override
	public void execute(Runnable command)
	{
		if(command instanceof BindRunnable)
		{
			Object bindKey = ((BindRunnable)command).getBindKey();
			ExecutorService executor = executorMap.get(bindKey);
			if(executor == null)
			{
				throw new IllegalArgumentException("no thread for key:" + bindKey);
			}
			executor.submit(command);
		}
		else
		{
			getRandom().submit(command);
		}
	}

	private ExecutorService getRandom()
	{
		Collection<ExecutorService> values = executorMap.values();
		if(values.size() == 0)
		{
			register(HOLD_KEY);
			return executorMap.get(HOLD_KEY);
		}

		List<ExecutorService> list = new ArrayList<>(values);
		return list.get(new Random().nextInt() % list.size());
	}

	public void register(String key)
	{
		executorMap.putIfAbsent(key, Executors.newSingleThreadExecutor(factory));
	}

	public static abstract class BindRunnable implements Runnable
	{
		private String bindKey;

		public BindRunnable(String bindKey)
		{
			this.bindKey = bindKey;
		}

		public String getBindKey()
		{
			return bindKey;
		}
	}
}
