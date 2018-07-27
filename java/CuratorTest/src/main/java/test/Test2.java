package test;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/7/14
 */
public class Test2
{
	public static void main(String[] args) throws Exception
	{
		CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", new ExponentialBackoffRetry(1000, 3));
		client.start();
		//final InterProcessMutex lock = new InterProcessMutex(client, "/" + 111);
		final InterProcessReadWriteLock lock = new InterProcessReadWriteLock(client, "/" + 111);
		final AtomicInteger i = new AtomicInteger(10);
		while(i.get() > 0)
		{
			new Thread(new Runnable()
			{
				int x = i.get();

				public void run()
				{
					try
					{
						lock.writeLock().acquire();
						System.out.println("start x=" + x);
						Thread.sleep(1000 * 3);
						System.out.println("start1 x=" + x);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					finally
					{
						try
						{
							System.out.println("end x=" + x);
							lock.writeLock().release();
						}
						catch(Exception e)
						{
							System.out.println("x=" + x + "  e=" + e);
						}
					}
				}
			}).start();
			i.decrementAndGet();
		}
		Thread.sleep(1000 * 60 * 50);
		client.close();
	}
}
