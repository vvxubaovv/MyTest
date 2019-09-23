package com.xubao.test.simpleTest.protobufTest.save;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.*;

public class AConver
{
	private static List<Field> aFieldList = new ArrayList<>();

	private static Map<String, Method> buildSetMethodMap = new HashMap<>();
	private static Map<String, Method> buildGetMethodMap = new HashMap<>();

	private static Map<String, Method> aSetMethodMap = new HashMap<>();

	public static void init()
	{
		aFieldList.addAll(Arrays.asList(A.class.getDeclaredFields()));

		for(Field field : aFieldList)
		{
			StringBuilder sb = new StringBuilder();
			char[] chars = field.getName().toCharArray();
			for(int i = 0; i < field.getName().length(); i++)
			{
				if(i == 0)
				{
					sb.append(Character.toUpperCase(chars[i]));
				}
				else
				{
					sb.append(chars[i]);
				}
			}
			if(field.getType() == Timestamp.class)
			{
				Method method = null;
				Method getMethod = null;
				Method aMethod = null;
				try
				{
					method = ForSave.ASave.Builder.class.getDeclaredMethod("set" + sb.toString(), long.class);
					getMethod = ForSave.ASave.class.getDeclaredMethod("get" + sb.toString());

					aMethod = A.class.getDeclaredMethod("set" + sb.toString(), Timestamp.class);
				}
				catch(NoSuchMethodException e)
				{
					e.printStackTrace();
				}
				buildSetMethodMap.put(field.getName(), method);
				buildGetMethodMap.put(field.getName(),getMethod);
				aSetMethodMap.put(field.getName(), aMethod);
			}
			else
			{

				Method method = null;
				Method getMethod = null;
				Method aMethod = null;
				try
				{
					method = ForSave.ASave.Builder.class.getDeclaredMethod("set" + sb.toString(), field.getType());
					getMethod = ForSave.ASave.class.getDeclaredMethod("get" + sb.toString());
					aMethod = A.class.getDeclaredMethod("set" + sb.toString(), field.getType());
				}
				catch(NoSuchMethodException e)
				{
					e.printStackTrace();
				}
				buildSetMethodMap.put(field.getName(), method);
				buildGetMethodMap.put(field.getName(), getMethod);
				aSetMethodMap.put(field.getName(), aMethod);
			}
		}
	}

	private static void aSaveSet(ForSave.ASave.Builder builder, A a, Field aField) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
	{
		String fieldName = aField.getName();
		Object aValue = aField.get(a);
//		System.out.println("set" + sb.toString());

		if(aField.getType() == Timestamp.class)
		{
			Method method = buildSetMethodMap.get(fieldName);
			method.invoke(builder, ((Timestamp)aValue).getTime());
		}
		else
		{
			Method method = buildSetMethodMap.get(fieldName);
			method.invoke(builder, aValue);
		}
	}

	public static ForSave.ASave toASave(A a) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
	{
		ForSave.ASave.Builder builder = ForSave.ASave.newBuilder();

		for(Field field : aFieldList)
		{
			field.setAccessible(true);
			Class<?> type = field.getType();
			if(type == int.class || type == Integer.class)
			{
				aSaveSet(builder, a, field);
			}
			else if(type == long.class || type == Long.class)
			{
				aSaveSet(builder, a, field);
			}
			else if(type == double.class || type == Double.class)
			{
				aSaveSet(builder, a, field);
			}
			else if(type == String.class)
			{
				aSaveSet(builder, a, field);
			}
			else if(type == Timestamp.class)
			{
				aSaveSet(builder, a, field);
			}
			else if(type == boolean.class || type == Boolean.class)
			{
				aSaveSet(builder, a, field);
			}
			else
			{
				throw new IllegalArgumentException("not supper " + type);
			}
		}
		return builder.build();
	}


	private static void aSet(ForSave.ASave aSave, A a, Field buildField) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
	{
		String fieldName = buildField.getName();
		Object aValue = buildGetMethodMap.get(fieldName).invoke(aSave);


		if(buildField.getType() == Timestamp.class)
		{
			Method method = aSetMethodMap.get(fieldName);
			method.invoke(a, new Timestamp((long)aValue));
		}
		else
		{
			Method method = aSetMethodMap.get(fieldName);
			method.invoke(a, aValue);
		}
	}

	public static A toA(ForSave.ASave aSave) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
	{
		A a = new A();

		for(Field field : aFieldList)
		{
			field.setAccessible(true);
			Class<?> type = field.getType();
			if(type == int.class || type == Integer.class)
			{
				aSet(aSave, a, field);
			}
			else if(type == long.class || type == Long.class)
			{
				aSet(aSave, a, field);
			}
			else if(type == double.class || type == Double.class)
			{
				aSet(aSave, a, field);
			}
			else if(type == String.class)
			{
				aSet(aSave, a, field);
			}
			else if(type == Timestamp.class)
			{
				aSet(aSave, a, field);
			}
			else if(type == boolean.class || type == Boolean.class)
			{
				aSet(aSave, a, field);
			}
			else
			{
				throw new IllegalArgumentException("not supper " + type);
			}
		}

		return a;
	}
}
