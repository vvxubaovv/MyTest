package com.xubao.test.simpleTest.jarTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/3/7
 */
public class JarTest2
{
	public static void main(String[] args) throws IOException
	{
		rePackage2("z://1.jar", "z://3.jar");
//		rePackage2("z://1.jar", "z://2.jar");

	}

	private static void rePackage2(String jarPath, String outPath) throws IOException
	{
		JarFile jarFileIn = new JarFile(jarPath);
		Manifest manifest = jarFileIn.getManifest();
		JarOutputStream jos = new JarOutputStream(new FileOutputStream(outPath), manifest);
		Enumeration<JarEntry> entries = jarFileIn.entries();
		while(entries.hasMoreElements())
		{
			JarEntry entry = entries.nextElement();

			try
			{
				jos.putNextEntry(new JarEntry(entry.getName()));
				if(!entry.isDirectory())
				{
					InputStream inputStream = jarFileIn.getInputStream(entry);
					byte[] buff = new byte[1024];
					int size;
					while((size = inputStream.read(buff)) != -1)
					{
						jos.write(buff, 0, size);
					}
				}
				jos.closeEntry();
				jos.flush();
			}
			catch(Exception e)
			{
				//e.printStackTrace();
			}
		}
		jos.flush();
		jos.close();

	}

	private static void rePackage(String jarPath, String outPath) throws IOException
	{
		JarOutputStream jos = new JarOutputStream(new FileOutputStream(outPath));

		JarFile jarFileIn = new JarFile(jarPath);
		Enumeration<JarEntry> entries = jarFileIn.entries();
		while(entries.hasMoreElements())
		{
			JarEntry entry = entries.nextElement();

			jos.putNextEntry(new JarEntry(entry.getName()));
			if(!entry.isDirectory())
			{
				InputStream inputStream = jarFileIn.getInputStream(entry);
				byte[] buff = new byte[1024];
				int size;
				while((size = inputStream.read(buff)) != -1)
				{
					jos.write(buff, 0, size);
				}
			}
			jos.closeEntry();
			jos.flush();
		}
		jos.flush();
		jos.close();


	}
}
