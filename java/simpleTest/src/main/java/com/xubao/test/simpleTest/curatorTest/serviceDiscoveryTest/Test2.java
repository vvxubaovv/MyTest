package com.xubao.test.simpleTest.curatorTest.serviceDiscoveryTest;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.retry.RetryForever;
import org.apache.curator.x.discovery.ServiceCache;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.details.ServiceCacheListener;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/3/5
 */
public class Test2
{
	public static void main(String[] args) throws Exception
	{
		CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.1.52:2181", new RetryForever(10));
		client.start();

		ServiceDiscovery<A> build = ServiceDiscoveryBuilder.builder(A.class).basePath("/sdt/test2").client(client).build();
		build.start();

		ServiceCache<A> cache = build.serviceCacheBuilder().name("33").build();
		cache.addListener(new ServiceCacheListener()
		{
			@Override
			public void cacheChanged()
			{
				System.out.println("cacheChanged");
			}

			@Override
			public void stateChanged(CuratorFramework client, ConnectionState newState)
			{
				System.out.println("stateChange");
			}
		});

		cache.start();



		System.in.read();

		cache.close();
//		build.close();
		client.close();
	}
}
