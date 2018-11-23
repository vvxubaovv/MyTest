package com.xubao.test.simpleTest.curatorTest;

import org.apache.curator.RetrySleeper;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryUntilElapsed;
import org.apache.zookeeper.CreateMode;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/10/24
 */
public class CuratorTest1
{
	public static void main(String[] args)
	{
		CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("192.168.1.52:2181", new RetryUntilElapsed(2*60*1000,500));
		try
		{
			curatorFramework.start();
			curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath("/curator1/a/b");

			curatorFramework.create().creatingParentContainersIfNeeded().withMode(CreateMode.EPHEMERAL).forPath("/curator2/a/b");

			System.in.read();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			curatorFramework.close();
		}
	}
}
