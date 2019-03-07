package com.xubao.test.simpleTest.curatorTest.serviceDiscoveryTest;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryForever;
import org.apache.curator.x.discovery.*;

import java.util.List;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/2/26
 */
public class Test1
{
	public static void main(String[] args) throws Exception
	{
		CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.1.52:2181", new RetryForever(10));
		client.start();

		A a = new A();
		a.setA(1);
		a.setB("b");

		//注册
		ServiceInstanceBuilder<A> builder = ServiceInstance.builder();
		ServiceInstance<A> si = builder.id("1")
				.name("")
				.payload(a).build();

		ServiceDiscovery<A> build = ServiceDiscoveryBuilder.builder(A.class).basePath("/sdt/test1").client(client).build();
		build.registerService(si);
		build.start();


		//发现
		ServiceDiscovery<A> b2 = ServiceDiscoveryBuilder.builder(A.class).basePath("/sdt").client(client).build();
		b2.start();

		ServiceCacheBuilder<A> cb = b2.serviceCacheBuilder();
		ServiceCache<A> sc = cb.name("test1").build();
		sc.start();


		List<ServiceInstance<A>> instances = sc.getInstances();
		System.out.println(instances);
		System.in.read();
	}

}
