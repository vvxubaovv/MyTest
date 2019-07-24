package com.xubao.test.simpleTest.fastjsonTest;

import com.alibaba.fastjson.JSON;
import com.xubao.Log;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/6/13
 */
public class LinkedHashMapTest
{
	public static void main(String[] args)
	{
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
		map.put("jfdsiajf", 34);
		map.put("q9a", 22);
		map.put("aaaa", 3);

		//按put顺序迭代输出
		Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		System.out.println(map);//toString顺序也按put顺序

		System.out.println("---------------------------");

		String s = JSON.toJSONString(new A(map));
		System.out.println(s);

		//在A.class中的map定义改为Map或HashMap 则输出顺序会改变
		//改为LinkedHashMap则迭代顺序保持不变
		A a = JSON.parseObject(s, A.class);
		a.linkedHashMap.put("333", 343);
		Iterator<Map.Entry<String, Integer>> iterator1 = a.linkedHashMap.entrySet().iterator();
		while(iterator1.hasNext())
		{
			System.out.println(iterator1.next());
		}
		System.out.println(a.linkedHashMap);


		String s1 = JSON.toJSONString(a);
		Log.log("s1={}",s1);
		a.linkedHashMap.put("1234",1234);
		Iterator<Map.Entry<String, Integer>> iterator2 = a.linkedHashMap.entrySet().iterator();
		while(iterator2.hasNext())
		{
			System.out.println(iterator2.next());
		}
		System.out.println(a.linkedHashMap);
	}


}
