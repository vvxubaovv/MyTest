package com.xubao.test.simpleTest.fastjsonTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/3/25
 */
public class Test2
{
	public static void main(String[] args)
	{
		Map<String, String> map = new HashMap<>();
		map.put("a", "aa");
		map.put("b", "bb");

		String s = JSON.toJSONString(map);
		System.out.println("s=" + s);

		Object parse = JSON.parse(s);
		System.out.println(parse);


		Map hashMap = JSON.parseObject(s, Map.class);//默认解析为HashMap
		System.out.println(hashMap);

		A a = new A("aa", "bb");
		String s1 = JSON.toJSONString(a, SerializerFeature.QuoteFieldNames);
		System.out.println(s1);

		Set<String> set = new HashSet<>(Arrays.asList("a", "b"));
		String s2 = JSON.toJSONString(set);
		Set set1 = JSON.parseObject(s2, HashSet.class);//直接从string到对象ok
		System.out.println(set1);


		Map<String, Object> map1 = new HashMap<>();

		map1.put("set1", set1);
		map1.put("i", new HashSet<Integer>(Arrays.asList(1, 2, 3)));

		String s3 = JSON.toJSONString(map1);
		ConcurrentHashMap<String, Object> map2 = JSON.parseObject(s3, ConcurrentHashMap.class);
		Object obj = map2.get("set1");//默认JSONArray
		Object i = map2.get("i");
		System.out.println(i);
		System.out.println(obj);
//		ArrayList arrayList = (ArrayList)obj;
//		System.out.println(arrayList);


		B b = new B();
		b.put("set1",set1);
		b.put("i",new HashSet<Integer>(Arrays.asList(1, 2, 3)));

		String s4 = JSON.toJSONString(b);
		B b1 = JSON.parseObject(s4, B.class);
		System.out.println(b1.getMap());
	}

	static class A
	{
		private String a;
		private String b;

		public A(String a, String b)
		{
			this.a = a;
			this.b = b;
		}
	}

	static class B
	{
		private Map<String, Object> map = new ConcurrentHashMap<>();

		public void put(String s, Object obj)
		{
			map.put(s, obj);
		}

		public Map<String, Object> getMap()
		{
			return map;
		}
	}
}
