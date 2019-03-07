package com.xubao.test.simpleTest.curatorTest;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;
import org.apache.curator.retry.RetryForever;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/2/25
 */
public class LockTest
{
	public static void main(String[] args) throws Exception
	{
		CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder();
		builder.sessionTimeoutMs(1000 * 20)
				.connectString("192.168.1.52:2181")
				.retryPolicy(new RetryForever(2000));
		CuratorFramework curatorFramework = builder.build();
		curatorFramework.start();

		test4(curatorFramework);
	}

	public static void test4(CuratorFramework client) throws Exception
	{
		InterProcessSemaphoreMutex mutex = new InterProcessSemaphoreMutex(client, "/LockTest/lock4");
		boolean acquire = false;
		while(!acquire)
		{
			acquire = mutex.acquire(3, TimeUnit.SECONDS);
			System.out.println("1------------- " + acquire);
		}
		System.in.read();

		mutex.release();

	}


	public static void test3(CuratorFramework client) throws Exception
	{
		InterProcessMutex lock = new InterProcessMutex(client, "/LockTest/lock3");
		String index = "1";

		boolean acquire = lock.acquire(10, TimeUnit.SECONDS);//获取失败节点删除

		List<String> temp = new ArrayList<>(lock.getParticipantNodes());
		Collections.sort(temp, (o1, o2) ->
				{
					int n1 = 0, n2 = 0;

					if(o1 != null)
					{
						int i1 = o1.lastIndexOf('-');
						n1 = Integer.parseInt(o1.substring(i1 + 1));
					}

					if(o2 != null)
					{
						int i2 = o2.lastIndexOf('-');
						n2 = Integer.parseInt(o2.substring(i2 + 1));
					}
					return n1 - n2;
				}
		);
		System.out.println(temp);

		if(acquire == true)
		{
			client.setData().forPath(temp.get(0), index.getBytes());
		}
		else
		{
			byte[] bytes = client.getData().forPath(temp.get(0));
			String s = new String(bytes, "utf8");
			if(s.equals(index))
			{
				System.out.println("可断开后重入");
				client.delete().forPath(temp.get(0));
				boolean rult = lock.acquire(5, TimeUnit.SECONDS);
				if(rult)
				{
					List<String> xx = new ArrayList<>(lock.getParticipantNodes());
					Collections.sort(temp, (o1, o2) ->
							{
								int n1 = 0, n2 = 0;

								if(o1 != null)
								{
									int i1 = o1.lastIndexOf('-');
									n1 = Integer.parseInt(o1.substring(i1 + 1));
								}

								if(o2 != null)
								{
									int i2 = o2.lastIndexOf('-');
									n2 = Integer.parseInt(o2.substring(i2 + 1));
								}
								return n1 - n2;
							}
					);
					client.setData().forPath(xx.get(0), index.getBytes());
				}
			}
		}

		System.out.println("1-------------");
		System.in.read();
		try

		{
			lock.release();
		}
		catch(
				IllegalMonitorStateException e)

		{
			// 未获取到锁 ignore
			System.out.println("未获取到锁,释放失败");
		}
		System.out.println("over");
	}

	public static void test2(CuratorFramework client) throws Exception
	{
		InterProcessReadWriteLock rwLock = new InterProcessReadWriteLock(client, "/LockTest/lock2");
		rwLock.writeLock().acquire(2, TimeUnit.SECONDS);
		rwLock.readLock().acquire(5, TimeUnit.SECONDS);
		System.out.println("1-------------");
		System.in.read();
		rwLock.readLock().release();
		rwLock.writeLock().release();
		System.out.println("over");
	}

	public static void test1(CuratorFramework client) throws Exception
	{
		InterProcessMutex lock1 = new InterProcessMutex(client, "/LockTest/lock1");

		System.out.println("1-------------------");
		lock1.acquire(30, TimeUnit.SECONDS);
		System.out.println("2-------------------");
		System.in.read();
		lock1.release();
		System.out.println("over");
	}
}
