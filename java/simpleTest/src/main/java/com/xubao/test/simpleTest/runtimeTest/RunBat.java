package com.xubao.test.simpleTest.runtimeTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class RunBat
{
	public static void main(String[] args)
	{
//		String workPath = args[0];
//		String batPath = args[1];

		String workPath = "z://";
		String batPath = "z://a.bat";

		Runtime runtime = Runtime.getRuntime();
		try
		{
			Process process = runtime.exec(String.format("cmd /C cd %s && call %s", workPath, batPath));
			InputStream inputStream = process.getInputStream();
			InputStream errorStream = process.getErrorStream();
			OutputStream outputStream = process.getOutputStream();

			Thread printThread = new Thread(() -> {

				while(true)
				{
					try
					{
						if(process.isAlive())
						{
							inputStream.transferTo(System.out);
							errorStream.transferTo(System.err);
						}
						else
						{
							inputStream.close();
							errorStream.close();
							break;
						}
					}
					catch(IOException e)
					{
						e.printStackTrace();
					}

					try
					{
						TimeUnit.MILLISECONDS.sleep(20);
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}
				}

			});
			printThread.setDaemon(true);
			printThread.start();


			AtomicInteger read = new AtomicInteger();
			AtomicBoolean notRead = new AtomicBoolean();
			Thread inThread = new Thread(() -> {
				while(true)
				{
					try
					{
						if(notRead.get())
						{
							Thread.yield();
							continue;
						}
						int r = System.in.read();
						read.set(r);
						notRead.compareAndSet(false, true);
					}
					catch(IOException e)
					{
						e.printStackTrace();
					}
				}
			});
			inThread.setDaemon(true);
			inThread.start();


			while(process.isAlive())
			{
				if(process.isAlive())
				{
					if(notRead.get())
					{
						int i = read.get();
						outputStream.write(i);
						if(i == 10)//换行
							outputStream.flush();
						notRead.compareAndSet(true, false);
						TimeUnit.MILLISECONDS.sleep(50);
					}
				}
				else
				{
					break;
				}
			}

			outputStream.close();
			process.destroyForcibly();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
