package com.xubao.test.simpleTest.jacksonTest;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/3/26
 */
public class Test1
{
	public static void main(String[] args) throws IOException
	{
		ObjectMapper objectMapper = new ObjectMapper();

		Map<String, Object> map = new HashMap<>();
		map.put("1", new HashSet<Integer>(Arrays.asList(1, 2, 3)));
		map.put("2", new HashSet<A>(Arrays.asList(new A("1", "2", "3", "4"), new A("a", "b", "c", "d"), new A())));

		String s = objectMapper.writeValueAsString(map);
		System.out.println("1---" + s);

		Map map1 = objectMapper.readValue(s, Map.class);//默认为LinkedHashMap  其中的set被反序列化为ArrayList
		Object o2 = map1.get("2");//o2类型为arraylist,其中的元素为LinkedHashMap 不知道类型信息 默认为LinkedHashMap
		System.out.println(map1);

		System.out.println("-----------------------------------");

		String s1 = objectMapper.writeValueAsString(B.A);
		System.out.println(s1);//"A"
		B b = objectMapper.readValue(s1, B.class);
		System.out.println(b);

	}

	static class A
	{
		private String a;
		private String b;
		private String c;
		private String d;

		public A()
		{
		}

		public A(String a, String b, String c, String d)
		{
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}

		public String getA()
		{
			return a;
		}

		public void setA(String a)
		{
			this.a = a;
		}

		public String getB()
		{
			return b;
		}

		public void setB(String b)
		{
			this.b = b;
		}

		public String getC()
		{
			return c;
		}

		public void setC(String c)
		{
			this.c = c;
		}

		public String getD()
		{
			return d;
		}

		public void setD(String d)
		{
			this.d = d;
		}
	}


	enum B
	{
		A, B, C
	}
}
