package com.xubao;

import java.util.regex.Pattern;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/5/17
 */
public class Log
{
	public static void log(String s, Object... args)
	{
		System.out.println(format(s, args));
	}

	public static void log(String s)
	{
		System.out.println(s);
	}

	public static void log(Object o)
	{
		System.out.println(o);
	}

	private static Pattern pattern = Pattern.compile("\\{\\}");

	private static String format(String s, Object[] args)
	{
		java.util.regex.Matcher matcher = pattern.matcher(s);
		StringBuilder sb = null;
		int count = 0;
		int index = 0;

		while(matcher.find())
		{
			if(sb == null)
			{
				sb = new StringBuilder();
			}
			for(int i = index; i < matcher.start(); i++)
			{
				sb.append(s.charAt(i));
			}
			index = matcher.end();
			try
			{
				sb.append(args[count] == null ? "null" : args[count].toString());
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				throw new RuntimeException("args length is litter than \"{}\"");
			}
			count++;
		}
		if(index != 0)
		{
			for(int i = index; i < s.length(); i++)
			{
				sb.append(s.charAt(i));
			}
		}
		if(count < args.length)
		{
			throw new RuntimeException("\"{}\" is more than args length");
		}

		return sb == null ? s : sb.toString();
	}
}
