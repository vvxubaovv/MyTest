package com.xubao.test.simpleTest.protobufTest;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/6/4
 */
public class ProtobufTest
{
	public static void main(String[] args)
	{
		try
		{
			compilePorto("D:\\git\\project\\selfWork\\MyTest\\java\\simpleTest\\src\\main\\resources\\protoc.exe","D:\\git\\project\\selfWork\\MyTest\\java\\simpleTest\\src\\main\\resources\\test.proto");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void compilePorto(String protoExePath,String protoFilePath) throws IOException
	{
		Runtime runtime = Runtime.getRuntime();
		String command = String.format("%s -I=. --descriptor_set_out=.\\test.desc --java_out=..\\java\\com\\xubao\\test\\simpleTest\\protobufTest %s",protoExePath,protoFilePath);
		System.out.println(command);
		Process exec = runtime.exec(command);
		InputStream errorStream = exec.getErrorStream();
//		while(errorStream.read()>-1)
	}
}
