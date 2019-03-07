package com.xubao.test.simpleTest.zipTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/3/4
 */
public class ZipTest
{
	public static void main(String[] args) throws Exception
	{
		String rootDir = "z://zip//1//";
		String savePath = "z://zip//1.jar";

		FileOutputStream fos = new FileOutputStream(savePath);
		CheckedOutputStream cos = new CheckedOutputStream(fos,
				new CRC32());

		ZipOutputStream zos = new ZipOutputStream(cos);
		compass(zos, new File(rootDir), "");

		zos.close();
		cos.close();
		fos.close();

	}

	private static void compass(ZipOutputStream zos, File parentDir, String dir) throws IOException
	{
		if(dir == null)
		{
			dir = "";
		}

		if(!parentDir.exists())
		{
			return;
		}
		File[] files = parentDir.listFiles();
		for(File file : files)
		{
			if(file.isDirectory())
			{
				compass(zos, file, dir + file.getName() + "/");
				zos.putNextEntry(new ZipEntry(dir + file.getName() + "/"));
			}
			else
			{
				zos.putNextEntry(new ZipEntry(dir + file.getName()));
				FileInputStream fis = new FileInputStream(file);
				byte[] buff = new byte[1024];
				while(fis.read(buff) > 0)
				{
					zos.write(buff);
				}
				zos.flush();
				fis.close();
			}
		}
	}
}