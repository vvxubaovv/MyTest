package com.xubao.test.simpleTest.btraceTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/12/14
 */
public class RunTest
{
	public static final String btracePath = "Z:\\btrace-bin-1.3.11.2\\bin\\btrace.bat";
	public static final String forTestPid = 39732 + "";

	public static void main(String[] args) throws IOException, InterruptedException
	{
		String path = getClassPath("JInfo.class");
		System.out.println(path);
		//权限不足 使用nircmd代替
//		printList(runCom("cmd /c "+btracePath+" "+forTestPid+" "+ path));

		printList(runCom("Z:\\nircmd-x64\\nircmd.exe elevate "+btracePath+" "+forTestPid+" "+ path));

	}

	public static String getClassPath(String name)
	{
		URL resource = RunTest.class.getResource(name);

		return resource == null ? null : resource.toString().substring(6);
	}

	public static List<String> runCom(String com) throws IOException, InterruptedException
	{
		System.out.println("命令: " + com);
		Runtime runtime = Runtime.getRuntime();
		Process exec = runtime.exec(com);
		BufferedReader inputStream = new BufferedReader(new InputStreamReader(exec.getInputStream(),"gbk"));
		BufferedReader errorStream = new BufferedReader(new InputStreamReader(exec.getErrorStream(),"gbk"));
		List<String> inputList = new ArrayList<>();
		String line = "";
		while((line = inputStream.readLine()) != null)
		{
			inputList.add(line);
		}
		while((line = errorStream.readLine()) != null)
		{
			inputList.add(line);
		}
		exec.waitFor();
		return inputList;
	}

	public static void printList(Collection<String> lineList)
	{
		for(String line : lineList)
		{
			System.out.println(line);
		}
	}
}
