package com.xubao.test.simpleTest.caffeineTest;

import com.github.benmanes.caffeine.cache.*;
import com.github.benmanes.caffeine.cache.stats.CacheStats;
import com.github.benmanes.caffeine.cache.stats.ConcurrentStatsCounter;
import com.github.benmanes.caffeine.cache.stats.StatsCounter;
import com.xubao.Log;
import org.checkerframework.checker.index.qual.NonNegative;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/5/5
 */
public class Test1
{
	public static void main(String[] args) throws Exception
	{
//		test2();
//		asyncTest();
//		test4();
//		test5();

		test6();
	}

	private static void test1() throws Exception
	{
		int[] i = new int[]{0};
		LoadingCache<String, String> build = Caffeine.newBuilder().expireAfterWrite(1, TimeUnit.SECONDS)
				.build(new CacheLoader<String, String>()
				{
					//默认的数据加载实现，当调用get取值的时候，如果key没有对应的值，就调用这个方法进行加载
					@Override
					public String load(String key)
					{
						return (i[0]++) + "";
					}
				});

		for(int x = 0; x < 10; x++)
		{
			@Nullable String s = build.get("1");
			System.out.println(s);
			TimeUnit.MILLISECONDS.sleep(500);

			@Nullable String s1 = build.get("1");
			System.out.println("2:" + s1);
			TimeUnit.SECONDS.sleep(2);
		}

	}

	private static void test2() throws Exception
	{
		int[] i = new int[]{0};
		LoadingCache<String, String> build = Caffeine.newBuilder().expireAfterWrite(1, TimeUnit.SECONDS)
				.recordStats()//开启统计
				.build(new CacheLoader<String, String>()
				{
					//默认的数据加载实现，当调用get取值的时候，如果key没有对应的值，就调用这个方法进行加载
					@Override
					public String load(String key)
					{
						return (i[0]++) + "";
					}
				});

		for(int x = 0; x < 10; x++)
		{
			@Nullable String s = build.get("1");
			System.out.println(s);
			TimeUnit.MILLISECONDS.sleep(500);
			build.invalidate("1");
			@Nullable String s1 = build.get("1");
			System.out.println("2:" + s1);
			TimeUnit.SECONDS.sleep(2);
		}
		CacheStats stats = build.stats();
		System.out.println(stats);
	}

	private static void asyncTest() throws Exception
	{
		AsyncCache<Object, Object> cache = Caffeine.newBuilder()
				.executor(Executors.newSingleThreadExecutor())
				.buildAsync();
		int[] a = new int[]{0};
		CompletableFuture<Object> future = cache.get("1", (key) ->
		{
			try
			{
				TimeUnit.SECONDS.sleep(2);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			return a[0]++;
		});
		System.out.println(future.get());
		System.out.println("over");


	}

	private static void test3() throws Exception
	{
		int[] i = new int[]{0};
		LoadingCache<String, String> build = Caffeine.newBuilder().expireAfterWrite(1, TimeUnit.SECONDS)
				.build(new CacheLoader<String, String>()
				{
					//默认的数据加载实现，当调用get取值的时候，如果key没有对应的值，就调用这个方法进行加载
					@Override
					public String load(String key)
					{
						return (i[0]++) + "";
					}
				});

		for(int x = 0; x < 10; x++)
		{
			@Nullable String s = build.get("1");
			System.out.println(s);
			TimeUnit.MILLISECONDS.sleep(500);

			@Nullable String s1 = build.get("1");
			System.out.println("2:" + s1);
			TimeUnit.SECONDS.sleep(2);
		}

	}

	private static void test4() throws Exception
	{
		int[] i = new int[]{0};
		StatsCounter statsCounter = new ConcurrentStatsCounter();
		LoadingCache<String, String> build = Caffeine.newBuilder().expireAfterWrite(1, TimeUnit.SECONDS)
				.recordStats(new Supplier<StatsCounter>()
				{
					@Override
					public StatsCounter get()
					{
						System.out.println("--supplier get");
						return statsCounter;
					}
				})
				.maximumSize(10)
				.softValues()//软引用 进程内存不足时释放
				.writer(new CacheWriter<String, String>()
				{
					@Override
					public void write(@NonNull String key, @NonNull String value)
					{
						System.out.println("write key:" + key + " value:" + value);
//						throw new RuntimeException("jjjj");
					}

					@Override
					public void delete(@NonNull String key, @Nullable String value, RemovalCause cause)
					{
						System.out.println("delete key:" + key + " value:" + value + " cause:" + cause);
					}
				})
				.removalListener(new RemovalListener<String, String>()
				{

					@Override
					public void onRemoval(@Nullable String key, @Nullable String value, RemovalCause cause)
					{
						System.out.println("removal key:" + key + " value:" + value + " cause:" + cause);
					}
				})
				.build(new CacheLoader<String, String>()
				{
					//默认的数据加载实现，当调用get取值的时候，如果key没有对应的值，就调用这个方法进行加载
					@Override
					public String load(String key)
					{
						return (i[0]++) + "";
//						return null;//返空表示未命中
					}
				});

		try
		{
			build.put("a", "aaaa");//会调write
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		for(int x = 0; x < 1000; x++)
		{
			@Nullable String s1 = build.get("" + (x / 10));
			if(x == 0)
			{
				build.invalidate("0");//会调delete 和 removal
			}
//			System.out.println("1:" + s1);
			if(x == 50)
				TimeUnit.MILLISECONDS.sleep(1000);
		}

		System.out.println(statsCounter);
	}


	private static void test5() throws Exception
	{
		int[] i = new int[]{0};
		LoadingCache<String, String> build = Caffeine.newBuilder().expireAfterAccess(1, TimeUnit.SECONDS)
				.build(new CacheLoader<String, String>()
				{
					//默认的数据加载实现，当调用get取值的时候，如果key没有对应的值，就调用这个方法进行加载
					@Override
					public String load(String key)
					{
						return (i[0]++) + "";
					}
				});
		build.put("1","7777");

		TimeUnit.SECONDS.sleep(2);
		System.out.println(build.get("1"));//没有了重新生成
		TimeUnit.SECONDS.sleep(2);
		System.out.println(build.get("1"));//没有了重新生成

	}

	private static void test6() throws Exception
	{
		int[] i = new int[]{0};
		LoadingCache<String, String> build = Caffeine.newBuilder().expireAfter(new Expiry<String, String>()
		{
			@Override
			public long expireAfterCreate(@NonNull String key, @NonNull String value, long currentTime)
			{
				Log.log("create--{}:{}:{}",key,value,currentTime);
				return TimeUnit.SECONDS.toNanos(20);
			}

			@Override
			public long expireAfterUpdate(@NonNull String key, @NonNull String value, long currentTime, @NonNegative long currentDuration)
			{
				//currentDuration
				//每条缓存有一个可用时间,为未来的一个时间点 currentDuration=可用时间点-now 即上一次的剩余可存活时间
				Log.log("update--{}:{}:{}:{}",key,value,currentTime,currentDuration);

				return TimeUnit.SECONDS.toNanos(2);
			}

			@Override
			public long expireAfterRead(@NonNull String key, @NonNull String value, long currentTime, @NonNegative long currentDuration)
			{
				Log.log("read--{}:{}:{}:{}",key,value,currentTime,currentDuration);
				return TimeUnit.SECONDS.toNanos(20);
			}
		})
				.build(new CacheLoader<String, String>()
				{
					//默认的数据加载实现，当调用get取值的时候，如果key没有对应的值，就调用这个方法进行加载
					@Override
					public String load(String key)
					{
						return (i[0]++) + "";
					}
				});
		build.put("1","7777");

		TimeUnit.SECONDS.sleep(2);
		System.out.println(build.get("1"));//没有了重新生成
		TimeUnit.SECONDS.sleep(2);
		System.out.println(build.get("1"));//没有了重新生成

		build.put("1","66666");  //update 设置过期时间
		System.out.println(build.get("1")); //read 设置过期时间  即覆盖了update设置的过期时间

		TimeUnit.SECONDS.sleep(2);
		System.out.println(build.get("1"));//所以能取到值

	}
}
