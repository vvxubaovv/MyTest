package test;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.util.concurrent.TimeUnit;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/7/14
 */
public class Test1
{
	public static void main(String[] args)
	{
		CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.1.52:2181", new ExponentialBackoffRetry(1000, 3));
		client.start();
		try
		{
			int i = 200;
			while(i>100){
			double random = Math.random();
			//client.create().withMode(CreateMode.EPHEMERAL).forPath("/xxbb/a"+random);
			client.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath("/xxbb/a"+i);
			i--;
			}}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		try
		{
			TimeUnit.SECONDS.sleep(30);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		client.close();
	}
}
