package com.xubao.test.simpleTest.exceptionTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleTest
{
	private static Logger log = LoggerFactory.getLogger(SimpleTest.class);

	public static void main(String[] args)
	{
		try
		{
			throw new NullPointerException();
		}
		catch(Exception e)
		{
			System.out.println(e);//不会出堆栈 只有报错类型
			log.error("e:{}", e);//会出堆栈
		}
	}
}
