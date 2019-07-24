package com.xubao.test.simpleTest.guavaTest.cacheTest;

import com.google.common.base.Ticker;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/5/13
 */
public class Test1
{
	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
		Cache<String, String> build = CacheBuilder.newBuilder()
//				.expireAfterAccess(10, TimeUnit.MILLISECONDS)
				.expireAfterWrite(100, TimeUnit.MILLISECONDS)
				.maximumSize(150)
				.initialCapacity(20)
				.recordStats()
				.softValues()
				.ticker(new Ticker()//内部获取时间
				{
					@Override
					public long read()
					{
						return System.nanoTime();
					}
				}).build(new CacheLoader<String,String>()
				{

					@Override
					public String load(String key) throws Exception
					{
						return "1" + key;
					}
				});

		int count = 100;

		for(int i = 0; i < count; i++)
		{
			build.put(i + "", i + ":" + i);
			TimeUnit.MILLISECONDS.sleep(20);
			System.out.println(build.getIfPresent(i + ""));
		}
		System.out.println(build.get(33 + "", new Callable<String>()
		{
			@Override
			public String call() throws Exception
			{
				return "xx";
			}
		}));
		System.out.println(build.size());

	}
}
