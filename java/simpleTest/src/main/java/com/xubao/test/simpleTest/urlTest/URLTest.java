package com.xubao.test.simpleTest.urlTest;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/3/6
 */
public class URLTest
{
	public static void main(String[] args) throws IOException
	{
		URL url = new URL("http://www.baidu.com");
		URLConnection connection = url.openConnection();
		InputStream inputStream = connection.getInputStream();
		byte[] buff = new byte[1024];
		int leng;
		while((leng = inputStream.read(buff)) > 0)
		{
			System.out.println(new String(buff, "utf8"));
		}
		inputStream.close();

		System.out.println(connection);
	}
}
