package test;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.nodes.PersistentNode;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/8/10
 */
public class Test3
{
	public static void main(String[] args) throws IOException
	{
		CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.1.52:2181", new ExponentialBackoffRetry(1000, 3));
		client.start();
		try
		{
			String path = "/xx/1";
			Stat stat = client.checkExists().forPath(path);
			if(stat == null)
			{
				//client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath(path);
				PersistentNode persistentNode = new PersistentNode(client, CreateMode.EPHEMERAL, false, path, "first".getBytes());
				persistentNode.start();
				System.in.read();
				System.exit(0);
			}
			else
			{
				client.setData().forPath(path, "hello world".getBytes("utf8"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		System.in.read();
	}
}
