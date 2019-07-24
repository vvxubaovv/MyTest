package com.xubao.test.simpleTest.runtimeTest;

import java.io.IOException;
import java.io.InputStream;

public class RunBat
{
	public static void main(String[] args)
	{
		String workPath = args[0];
		String batPath = args[1];

//		String workPath = "z://";
//		String batPath = "z://a.bat";

		Runtime runtime = Runtime.getRuntime();
		try
		{
			Process process = runtime.exec(String.format("cmd /C cd %s && call %s", workPath, batPath));
			InputStream inputStream = process.getInputStream();
			InputStream errorStream = process.getErrorStream();
//			byte[] buf = new byte[1024];
//			while(inputStream.available() > 0)
//			{
//				int read = inputStream.read(buf);
//				System.out.println(new String(buf, 0, read, "utf8"));
//			}
//
//			while(errorStream.available() > 0)
//			{
//				int read = errorStream.read(buf);
//				System.out.println(new String(buf, 0, read, "utf8"));
//			}
			inputStream.transferTo(System.out);
			errorStream.transferTo(System.out);
			process.waitFor();
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
