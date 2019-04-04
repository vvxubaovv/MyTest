package com.xubao.test.simpleTest.curatorTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.retry.RetryUntilElapsed;
import org.apache.curator.x.discovery.*;
import org.apache.curator.x.discovery.details.JsonInstanceSerializer;
import org.apache.curator.x.discovery.details.ServiceCacheListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/11/15
 */
public class ServiceDiscoverTest2
{
	public static void main(String[] args) throws Exception
	{
		CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("192.168.1.52:2181", new RetryUntilElapsed(2 * 60 * 1000, 500));
		curatorFramework.start();

		int id = new Random().nextInt();
		String name = "233";//new Random().nextInt()+"";

		ServiceInstanceBuilder<Test> x11 = ServiceInstance.builder();
		x11.payload(Test.init(id, name, name));
		x11.address(name);
		x11.name(name);
		x11.id(id + "");
		ServiceDiscovery<Test> testServiceDiscovery = ServiceDiscoveryBuilder.builder(Test.class)
				.serializer(new MyJsonInstanceSerializer<>(Test.class)).client(curatorFramework).basePath("/disTest1").thisInstance(x11.build()).build();
		testServiceDiscovery.start();

		ServiceCacheBuilder<Test> serviceCacheBuilder = testServiceDiscovery.serviceCacheBuilder();
		serviceCacheBuilder.name(name);//服务名 父目录

		ServiceCache<Test> cache = serviceCacheBuilder.build();
		cache.addListener(new ServiceCacheListener()
		{
			@Override
			public void cacheChanged()
			{
				System.out.println("change");
			}

			@Override
			public void stateChanged(CuratorFramework client, ConnectionState newState)
			{

			}
		});

		cache.start();

		System.out.println("===================================");
		System.out.println(cache.getInstances());


		System.in.read();
	}

	static class Test
	{
		private String name;
		private int age;
		private List<List<List<String>>> x;

		public String getName()
		{
			return name;
		}

		public void setName(String name)
		{
			this.name = name;
		}

		public int getAge()
		{
			return age;
		}

		public void setAge(int age)
		{
			this.age = age;
		}

		public List<List<List<String>>> getX()
		{
			return x;
		}

		public void setX(List<List<List<String>>> x)
		{
			this.x = x;
		}

		public static Test init(int age, String name, String x)
		{
			Test test = new Test();
			test.setAge(age);
			test.setName(name);

			List<String> x1 = new ArrayList<>();
			List<List<String>> x2 = new ArrayList<>();
			List<List<List<String>>> x3 = new ArrayList<>();

			x3.add(x2);
			x2.add(x1);
			x1.add(x);

			test.setX(x3);

			return test;
		}

		@Override
		public String toString()
		{
			return "Test{" +
					"name='" + name + '\'' +
					", age=" + age +
					", x=" + x +
					'}';
		}
	}


	static class MyJsonInstanceSerializer<T> extends JsonInstanceSerializer<T>
	{
		public MyJsonInstanceSerializer(Class<T> payloadClass)
		{
			super(payloadClass);
		}

		@Override
		public ServiceInstance<T> deserialize(byte[] bytes) throws Exception
		{
			JSONObject parse = (JSONObject)JSON.parse(bytes);
			System.out.println(parse);

			JSONObject o = (JSONObject)parse.get("payload");
			o.replace("name","徐豹");

//			parse.replace("payload", null);
			byte[] bs = JSON.toJSONBytes(parse);
			System.out.println("bs.le=" + bs.length);
			System.out.println(super.deserialize(bs));
			return super.deserialize(bs);
		}
	}
}
