package test;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorListener;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/7/14
 */
public class Test
{
	public static void main(String[] args) throws Exception
	{
		CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.1.52:2181", new ExponentialBackoffRetry(1000, 3));
		client.getConnectionStateListenable().addListener(new ConnectionStateListener()
		{
			public void stateChanged(CuratorFramework client, ConnectionState newState)
			{
				System.out.println("连接状态:" + newState.name());
				//           supended
				//           /  |  |  \
				//connected /   |  |   \lost
				//           reconnected
				//
			}
		});
		//curator自身产生的事件监听
		client.getCuratorListenable().addListener(new CuratorListener()
		{
			public void eventReceived(CuratorFramework client, CuratorEvent event) throws Exception
			{
				System.out.println("client="+client+"  event="+event);
			}
		});
		//对应节点产生的事件
		TreeCache treeCache = new TreeCache(client,"/xxbb");
		treeCache.getListenable().addListener(new TreeCacheListener()
		{
			public void childEvent(CuratorFramework curatorFramework, TreeCacheEvent treeCacheEvent) throws Exception
			{
				System.out.println("frame="+curatorFramework+"   event="+treeCacheEvent);
			}
		});

		//对应节点产生的事件
		TreeCache treeCache1 = new TreeCache(client,"/xxbb1");
		treeCache.getListenable().addListener(new TreeCacheListener()
		{
			public void childEvent(CuratorFramework curatorFramework, TreeCacheEvent treeCacheEvent) throws Exception
			{
				System.out.println("frame="+curatorFramework+"   event="+treeCacheEvent);
			}
		});
		treeCache1.start();
		//即使不存在xxbb1创建xxbb1后也可以接收事件
		PathChildrenCache pathChildrenCache = new PathChildrenCache(client,"/xxbb1",true);
		pathChildrenCache.getListenable().addListener(new PathChildrenCacheListener()
		{
			public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception
			{
				System.out.println("child  c="+client+"   event="+event);
			}
		});
		pathChildrenCache.start();
		treeCache.start();
		client.start();
		try
		{

			client.create().inBackground().forPath("/xxbb1/xb2", "xubao".getBytes());
			byte[] bytes = client.getData().forPath("/xxbb/xb2");
			System.out.println(new String(bytes));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			//client.close();
		}
		try
		{
			Thread.sleep(1000000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}

	}

}
