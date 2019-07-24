package com.xubao.test.simpleTest.jctoolsTest;

import org.jctools.maps.NonBlockingHashMap;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/5/14
 */
public class UseTest1
{
	public static void main(String[] args)
	{
		NonBlockingHashMap<String,String> map = new NonBlockingHashMap();
		map.put("1","1");
		map.contains("1");
		map.containsValue("1");
	}
}
