public class Test
{
	public static void main(String[] args)
	{

		Runnable runnable = new Runnable()
		{
			@Override
			public void run()
			{
				System.out.println("start");
				try
				{
					Thread.sleep(2);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
				try
				{
					Thread.sleep(2);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}

				System.out.println("end");
			}
		};

		Thread thread = new Thread(runnable);

		thread.start();

		System.out.println("join");
		try
		{
			thread.join();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
