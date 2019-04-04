package com.xubao.test.simpleTest.shutdownHookTest;

import java.io.IOException;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/3/11
 */
public class ShutdownHookTest
{
	public static void main(String[] args) throws IOException
	{
		Runtime runtime = Runtime.getRuntime();
		runtime.addShutdownHook(new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				//正常退出触发
				//taskkill /f /pid  不触发
				//kill  能触发
				//ide 直接关不触发
				System.out.println("关闭");
			}
		}));

		System.in.read();
	}
}
