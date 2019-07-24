package com.xubao.test.simpleTest.collectionTest;

import com.xubao.Log;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/6/14
 */
public class ConcurrentMapTest
{
//		static Map<String, String> map = new ConcurrentHashMap<>();
	static Map<String, String> map = new HashMap<>();

	static
	{
		for(int i = 0; i < 10; i++)
		{
			map.put("" + i, "" + i);
		}
	}

	static abstract class MyRunnable implements Runnable
	{
		String name;
		boolean stop;
		int second;

		public MyRunnable(boolean stop, int second)
		{
			this.stop = stop;
			this.second = second;
		}

		public MyRunnable(String name, boolean stop, int second)
		{
			this.name = name;
			this.stop = stop;
			this.second = second;
		}
	}

	static Runnable iteratorStop = new MyRunnable("iteratorStop", true, 1)
	{
		boolean first = true;

		@Override
		public void run()
		{
			Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
			while(iterator.hasNext())
			{
				//普通map其他线程删除完后 这里会报错  ConcurrentHashMap睡醒后这里能取到下一个的值,但下下个值已经取不到 hasNext()==false直接退出
				Map.Entry<String, String> next = iterator.next();
				Log.log("{}:{}", name, next);
				if(first)
				{
					stop(name, stop, second);
					first = false;
				}
			}
		}
	};

	static Runnable normal = new MyRunnable("normal", false, 0)
	{
		@Override
		public void run()
		{
			Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
			while(iterator.hasNext())
			{
				Map.Entry<String, String> next = iterator.next();
				Log.log("{}:{}", name, next);
			}
		}
	};

	static Runnable remove = new MyRunnable("remove", false, 0)
	{
		@Override
		public void run()
		{
			Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
			while(iterator.hasNext())
			{
				Map.Entry<String, String> next = iterator.next();
				Log.log("{}:{}", name, next);
				iterator.remove();
			}
		}
	};

	static Runnable change = new MyRunnable("change", false, 0)
	{
		@Override
		public void run()
		{
			Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
			while(iterator.hasNext())
			{
				Map.Entry<String, String> next = iterator.next();
				next.setValue("change:"+next.getValue());
				Log.log("{}:{}", name, next);
			}
		}
	};

	static Runnable changeSleep = new MyRunnable("changeSleep", false, 1)
	{
		@Override
		public void run()
		{
			Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
			while(iterator.hasNext())
			{
				Map.Entry<String, String> next = iterator.next();
				next.setValue("changeSleep:"+next.getValue());
				stop(name,stop,0);
				Log.log("{}:{}", name, next);
			}
		}
	};


	public static void main(String[] args) throws InterruptedException
	{
		Thread normalThread = new Thread(changeSleep);
		Thread iteratorStopThread = new Thread(iteratorStop);

		iteratorStopThread.start();
		TimeUnit.SECONDS.sleep(1);

		normalThread.start();
	}


	private static void stop(String name, boolean stop, int second)
	{
		if(stop)
		{
			try
			{
				Log.log("{}:stop start", name);
				TimeUnit.SECONDS.sleep(second);
				Log.log("{}:stop end", name);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
