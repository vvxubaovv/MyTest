package quasar.test;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.FiberExecutorScheduler;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.strands.SuspendableCallable;
import co.paralleluniverse.strands.SuspendableRunnable;
import co.paralleluniverse.strands.channels.Channels;
import co.paralleluniverse.strands.channels.IntChannel;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class SimpleTest
{
	static public Integer doAll() throws ExecutionException, InterruptedException
	{
		final IntChannel increasingToEcho = Channels.newIntChannel(0); // Synchronizing channel (buffer = 0)
		final IntChannel echoToIncreasing = Channels.newIntChannel(0); // Synchronizing channel (buffer = 0)

		Fiber<Integer> increasing = new Fiber("INCREASER", new SuspendableCallable<Integer>()
		{

			public Integer run() throws SuspendExecution, InterruptedException
			{
				////// The following is enough to test instrumentation of synchronizing methods
				// synchronized(new Object()) {}

				int curr = 0;
				for(int i = 0; i < 10; i++)
				{
					Fiber.sleep(10);
					System.out.println("INCREASER sending: " + curr);
					increasingToEcho.send(curr);
					curr = echoToIncreasing.receive();
					System.out.println("INCREASER received: " + curr);
					curr++;
					System.out.println("INCREASER now: " + curr);
				}
				System.out.println("INCREASER closing channel and exiting");
				increasingToEcho.close();
				return curr;
			}
		}).start();

		Fiber<Void> echo = new Fiber<Void>("ECHO", new SuspendableRunnable()
		{
			public void run() throws SuspendExecution, InterruptedException
			{
				Integer curr;
				while(true)
				{
					Fiber.sleep(1000);
					curr = increasingToEcho.receive();
					System.out.println("ECHO received: " + curr);

					if(curr != null)
					{
						System.out.println("ECHO sending: " + curr);
						echoToIncreasing.send(curr);
					}
					else
					{
						System.out.println("ECHO detected closed channel, closing and exiting");
						echoToIncreasing.close();
						return;
					}
				}
			}
		}).start();

		try
		{
			increasing.join();
			echo.join();
		}
		catch(ExecutionException e)
		{
			e.printStackTrace();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}

		return increasing.get();
	}


	private static void connect(String url, String name)
	{
		try
		{
			System.out.println("start " + name);
			URLConnection urlConnection = new URL(url).openConnection();
			urlConnection.connect();
			System.out.println("connect over " + name);
			InputStream inputStream = urlConnection.getInputStream();
//			inputStream.transferTo(System.out);
			System.out.println("read over " + name);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	private static void ff()
	{
		ExecutorService executorService = Executors.newFixedThreadPool(2, new ThreadFactory()
		{
			int i = 0;

			@Override
			public Thread newThread(Runnable r)
			{
				return new Thread(r, "thread--" + (i++));
			}
		});
		FiberExecutorScheduler fiberExecutorScheduler = new FiberExecutorScheduler("xxx", executorService);

		String url = "http://www.baidu.com";
		Fiber f1 = new Fiber(fiberExecutorScheduler, new SuspendableRunnable()
		{
			@Override
			public void run() throws SuspendExecution, InterruptedException
			{
				System.out.println("f1--------------start");
				System.out.println(Thread.currentThread().getName());
				connect(url, "f1");
				System.out.println("f1---------------end");
			}
		});

		Fiber f2 = new Fiber(fiberExecutorScheduler, new SuspendableRunnable()
		{
			@Override
			public void run() throws SuspendExecution, InterruptedException
			{
				System.out.println("f2--------------start");
				System.out.println(Thread.currentThread().getName());
				connect(url, "f2");
				System.out.println("f2--------------end");
			}
		});

		Fiber f3 = new Fiber(fiberExecutorScheduler, new SuspendableRunnable()
		{
			@Override
			public void run() throws SuspendExecution, InterruptedException
			{
				System.out.println("f3--------------start");
				System.out.println(Thread.currentThread().getName());
				connect(url, "f3");
				System.out.println("f3--------------end");
			}
		});

		Fiber f4 = new Fiber(fiberExecutorScheduler, new SuspendableRunnable()
		{
			@Override
			public void run() throws SuspendExecution, InterruptedException
			{
				System.out.println("f4--------------start");
				System.out.println(Thread.currentThread().getName());
				connect(url, "f4");
				System.out.println("f4--------------end");
			}
		});

		Fiber f5 = new Fiber(fiberExecutorScheduler, new SuspendableRunnable()
		{
			@Override
			public void run() throws SuspendExecution, InterruptedException
			{
				System.out.println("f5--------------start");
				System.out.println(Thread.currentThread().getName());
				connect(url, "f5");
				System.out.println("f5--------------end");
			}
		});

		f1.start();
		f2.start();
		f3.start();
		f4.start();
		f5.start();

		try
		{
			f1.join();
			f2.join();

			f3.join();
			f4.join();
			f5.join();
		}
		catch(ExecutionException e)
		{
			e.printStackTrace();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	static public void main(String[] args) throws ExecutionException, InterruptedException
	{
//		doAll();

		ff();
	}
}
