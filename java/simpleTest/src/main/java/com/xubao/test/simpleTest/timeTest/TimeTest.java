package com.xubao.test.simpleTest.timeTest;

import java.time.ZoneId;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/10/23
 */
public class TimeTest
{
	public static void main(String[] args)
	{
		TimeZone timeZone = TimeZone.getTimeZone(ZoneId.systemDefault());
		int offset = timeZone.getOffset(System.currentTimeMillis());
		System.out.println(offset);
	}
}
