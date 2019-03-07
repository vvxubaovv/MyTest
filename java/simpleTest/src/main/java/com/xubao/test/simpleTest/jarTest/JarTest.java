package com.xubao.test.simpleTest.jarTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/3/4
 */
public class JarTest
{
	public static void main(String[] args) throws IOException
	{
		String path = "z://1.jar";
		JarFile jarFile = new JarFile(path);
		Enumeration<JarEntry> entries = jarFile.entries();
		String baseDir = "z://xx";
		while(entries.hasMoreElements())
		{
			JarEntry entry = entries.nextElement();
			System.out.println(entry.getName());
			if(entry.isDirectory())
			{
				File file = new File(baseDir + "//" + entry.getName());
				if(!file.exists())
				{
					if(!file.mkdirs())
					{
						throw new RuntimeException("创建文件夹失败: " + file.getAbsolutePath());
					}
				}
			}
			else
			{
				ZipEntry zipEntry = jarFile.getEntry(entry.getName());
				InputStream is = jarFile.getInputStream(zipEntry);
				String p = baseDir + "//" + entry.getName();
				File file = new File(p.substring(0, p.lastIndexOf("/")));
				if(!file.exists())
				{
					if(!file.mkdirs())
					{
						throw new RuntimeException("创建文件夹失败: " + file.getAbsolutePath());
					}
				}
				copyEntry(p, is);
				is.close();
			}
		}
	}

	private static void copyEntry(String path, InputStream is) throws IOException
	{
		File file = new File(path);
		try(FileOutputStream fos = new FileOutputStream(file))
		{
			byte[] buff = new byte[1024];
			while(is.read(buff) > 0)
			{
				fos.write(buff);
			}
		}
	}
}
