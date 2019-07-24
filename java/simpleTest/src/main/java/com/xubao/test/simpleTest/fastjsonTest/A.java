package com.xubao.test.simpleTest.fastjsonTest;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/6/13
 */
public class A
{
	public A(LinkedHashMap linkedHashMap)
	{
		this.linkedHashMap = linkedHashMap;
	}

//	public A(HashMap linkedHashMap)
//	{
//		this.linkedHashMap = linkedHashMap;
//	}

//	public A(Map linkedHashMap)
//	{
//		this.linkedHashMap = linkedHashMap;
//	}

	public A()
	{
	}

	public LinkedHashMap linkedHashMap = new LinkedHashMap();
}
