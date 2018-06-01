package com.xubao.test.simpleTest.threadTest;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/5/31
 */
public class ThreadTest1
{
	private static X x;
	public static void main(String[] args)
	{
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				System.out.println("before--------");
				x = new X("dsf");
				System.out.println("after---------");
				x.printX();
			}
		}).start();
		try
		{
			Thread.sleep(100);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}

		x.printX();
	}

	public static class X{
		private int y = 1000000000;
		public X(){
			try
			{
				Thread.sleep(10000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		public X(String x){
			new Thread(new Runnable()
			{
				@Override
				public void run()
				{
					System.out.println("xxxxxxxxxxxxxxx");
					X.this.printX();
					System.out.println("yyyyyyyyyyyyyy");
				}
			}).start();

			try
			{
				Thread.sleep(10000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			y = 10000;
			System.out.println("zzzzzzzzzzzzzzzzz");
		}

		public void printX(){
			System.out.println("x"+"------"+y);
		}
	}
}
