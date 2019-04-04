package com.xubao.test.simpleTest.regexTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/3/15
 */
public class regexTest
{
	public static void main(String[] args)
	{
		Pattern p = Pattern.compile("a/.*");
		Matcher matcher = p.matcher("a/jiji");
		System.out.println(matcher.matches());
	}
}
