package com.xubao.test.simpleTest.perf4jTest;

import org.perf4j.StopWatch;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/11/21
 */
public class Test
{
	public static void main(String[] args) throws Exception
	{
		int count = 99999;
		Random random = new Random();
		File file = new File("z://xx.txt");
		FileOutputStream fos = new FileOutputStream(file);
		for(int i = 0; i < count; i++)
		{
			StopWatch stopWatch = new StopWatch();
			stopWatch.start("111");
			Thread.sleep(Math.abs(random.nextInt() % 10) + 1);
			fos.write(stopWatch.stop().getBytes());
		}

		fos.flush();
		fos.close();
	}

}
