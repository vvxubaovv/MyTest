package com.xubao.test.simpleTest.fileTest;

import java.io.File;
import java.io.IOException;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/3/15
 */
public class FileTest
{
	public static void main(String[] args) throws IOException
	{
		File a1 = new File("z://a1.txt");
		if(!a1.exists())
		{
			a1.createNewFile();
		}
		File a2 = new File("z://a2.txt");
		//文件存在失败
		boolean rult = a1.renameTo(a2);
		if(!rult)
		{
			//可以不同文件夹  aa存在
			rult = a1.renameTo(new File("z://aa//a2.txt"));
			if(!rult)
			{
				//文件夹不存在失败  bb不存在
				a1.renameTo(new File("z://bb//aa.txt"));
			}
		}
	}
}
