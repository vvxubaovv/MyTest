package com.xubao.test.simpleTest.proxyTest.original;


import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.imps.CuratorFrameworkImpl;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;
import org.apache.curator.retry.RetryUntilElapsed;
import org.apache.zookeeper.CreateMode;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/4/10
 */
public class OProxyTest
{
	public static void main(String[] args)
	{
		//CuratorFrameworkImpl.DebugBackgroundListener
		try
		{
			//绝对路径是CuratorFrameworkImpl$DebugBackgroundListener 不是CuratorFrameworkImpl.DebugBackgroundListener
			Class<?> clazz = DynamicProxy.class.getClassLoader().loadClass("org.apache.curator.framework.imps.CuratorFrameworkImpl$DebugBackgroundListener");
			System.out.println(clazz);

			//创建实现特定接口的对象,并实现方法代理
			//在这里实现了 '实现其他jar包 包内可见接口'
			Object subject = Proxy.newProxyInstance(DynamicProxy.class.getClassLoader(), new Class[]{clazz}, new DynamicProxy());
			System.out.println(subject.getClass());



			CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("192.168.1.52:2181", new RetryUntilElapsed(2*60*1000,500));

			//注入创建的对象
			Field listener = CuratorFrameworkImpl.class.getDeclaredField("debugListener");
			listener.setAccessible(true);
			listener.set(curatorFramework,subject);


			try
			{
				curatorFramework.start();
				InterProcessSemaphoreMutex mutex = new InterProcessSemaphoreMutex(curatorFramework, "/LockTest/lock4");
				boolean acquire = false;
				while(!acquire)
				{
					acquire = mutex.acquire(3, TimeUnit.SECONDS);
					System.out.println("1------------- " + acquire);
				}
				System.in.read();

				mutex.release();
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
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(NoSuchFieldException e)
		{
			e.printStackTrace();
		}
		catch(IllegalAccessException e)
		{
			e.printStackTrace();
		}
	}

	static class DynamicProxy implements InvocationHandler
	{
		//对接口方法的调用 都会转为invoke方法的调用
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
		{
			for(Object obj:args){
				System.out.print(obj.toString()+" | ");
			}
			System.out.println();
			return null;
		}
	}
}
