package com.xubao.compoundXml;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/3/26
 */
public class CompoundXml
{
	public static BufferedReader readFile(String filePath) throws FileNotFoundException
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));

		return bufferedReader;
	}

	public static BufferedWriter writeFile(String filePath) throws FileNotFoundException
	{
		File file = new File(filePath);
		//file.deleteOnExit();
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));

		return bufferedWriter;
	}

	public static BufferedWriter copyFile(boolean isFirst, boolean isLast, BufferedWriter bufferedWriter, BufferedReader bufferedReader) throws IOException
	{
		if(!isFirst)
		{
			bufferedReader.readLine();
		}
		String first = bufferedReader.readLine();
		String second = bufferedReader.readLine();
		while(second != null)
		{
			bufferedWriter.write(first);
			bufferedWriter.write('\n');
			first = second;
			second = bufferedReader.readLine();
		}

		if(isLast)
		{
			bufferedWriter.write(first);
			//bufferedWriter.write('\n');
		}

		return bufferedWriter;
	}

	public static void main(String[] args) throws Exception
	{
		compoundXml();

		//runCmd("python z:/quickgen1.py org_all.xml");
	}

	public static void compoundXml() throws IOException
	{
		String dir = "C:\\Users\\admin\\Desktop\\原始xml";
		File fileDir = new File(dir);
		File[] files = fileDir.listFiles();

		List<File> fileList =  new ArrayList<File>(files.length);
		for(File file : files)
		{
			if(!file.getName().endsWith("org_all.xml")){
				fileList.add(file);
			}
		}


		BufferedWriter bufferedWriter = writeFile("C:\\Users\\admin\\Desktop\\原始xml\\" + "org_all.xml");
		int i = 0;
		for(File file : fileList)
		{
			BufferedReader bufferedReader = readFile(file.getAbsolutePath());
			boolean isFirst = false;
			boolean isLast = false;
			if(i == 0)
			{
				isFirst = true;
			}

			if(i == files.length - 1)
			{
				isLast = true;
			}

			copyFile(isFirst, isLast, bufferedWriter, bufferedReader);
			bufferedReader.close();

			i++;
		}

		bufferedWriter.close();
	}

	public static void runCmd(String cmd) throws IOException
	{
		Runtime runtime = Runtime.getRuntime();
		Process exec = runtime.exec(cmd);
		OutputStream outputStream = exec.getOutputStream();
		InputStream errorStream = exec.getErrorStream();

	}
}
