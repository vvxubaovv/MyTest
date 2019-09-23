package com.xubao.test.simpleTest.protobufTest.save;

import com.alibaba.fastjson.JSON;
import com.google.protobuf.InvalidProtocolBufferException;

import java.lang.reflect.InvocationTargetException;

public class Main
{
	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
	{
		A a = null;
		try
		{
			a = A.mockA();
		}
		catch(IllegalAccessException e)
		{
			e.printStackTrace();
		}

		AConver.init();

		System.out.println(a);

		System.out.println(A.toProto());

		ForSave.ASave aSave = AConver.toASave(a);
		System.out.println(aSave);


		String s = JSON.toJSONString(a);
		System.out.println("json size:" + s.getBytes().length);

		byte[] data = aSave.toByteArray();
		System.out.println("proto size:" + aSave.toByteArray().length);


		jsonSerTest(10000, a);
		protoSerTest(10000, a);


		A a1 = AConver.toA(aSave);
		System.out.println(a1);


		jsonUnSerTest(10000,s);
		protoUnSerTest(10000,data);
	}

	private static void jsonSerTest(int count, A a)
	{
		long start = System.currentTimeMillis();
		for(int i = 0; i < count; i++)
		{
			String s = JSON.toJSONString(a);
		}
		long end = System.currentTimeMillis();
		System.out.println("spend:" + (end - start));
	}

	private static void protoSerTest(int count, A a)
	{
		long start = System.currentTimeMillis();
		try
		{
			for(int i = 0; i < count; i++)
			{
				ForSave.ASave aSave = AConver.toASave(a);
				aSave.toByteArray();
			}
		}
		catch(NoSuchMethodException e)
		{
			e.printStackTrace();
		}
		catch(IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch(InvocationTargetException e)
		{
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("spend:" + (end - start));
	}


	private static void jsonUnSerTest(int count, String str)
	{
		long start = System.currentTimeMillis();
		for(int i = 0; i < count; i++)
		{
			A a = (A)JSON.parseObject(str,A.class);
		}
		long end = System.currentTimeMillis();
		System.out.println("spend:" + (end - start));
	}

	private static void protoUnSerTest(int count, byte[] data)
	{
		long start = System.currentTimeMillis();
		try
		{
			for(int i = 0; i < count; i++)
			{
				ForSave.ASave aSave = ForSave.ASave.parseFrom(data);
				A a = AConver.toA(aSave);
			}
		}
		catch(NoSuchMethodException e)
		{
			e.printStackTrace();
		}
		catch(IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch(InvocationTargetException e)
		{
			e.printStackTrace();
		}
		catch(InvalidProtocolBufferException e)
		{
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("spend:" + (end - start));
	}
}
