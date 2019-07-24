package com.xubao.test.simpleTest.guavaTest.utilsTest;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/5/16
 */
public class SplitterTest
{
	public static void main(String[] args)
	{
//		test1();
//		test2();
		test3();
	}

	private static void test3()
	{
		String src = "1->2,3->4";
		Map<String, String> splitM1 = Splitter.on(",")
				.withKeyValueSeparator("->")
				.split(src);
		System.out.println(splitM1);

		String src2 = "1->2,3->4";
		Map<String, String> splitM2 = Splitter.on(CharMatcher.anyOf(","))
				.withKeyValueSeparator("->")
				.split(src2);
		System.out.println(splitM2);
	}

	private static void test2()
	{
		String src = "a.b.  c  .d.e.f.  e.f.  e.e  .   . ";
		String[] split = src.split("[,./]");
		System.out.println(Arrays.asList(split));

		Iterable<String> split1 = Splitter.on(CharMatcher.anyOf(",./"))
				.limit(2)//切成几份
				.split(src);
		System.out.println(split1);


		Iterable<String> split2 = Splitter.on(CharMatcher.anyOf(",./"))
				.trimResults()//去空格
				.split(src);
		System.out.println(split2);

		Iterable<String> split3 = Splitter.on(CharMatcher.anyOf(",./"))
				.omitEmptyStrings()//去掉空字符串""
				.trimResults() //两个相加,不分先后  去除空白字符串
				.split(src);
		System.out.println(split3);

		List<String> split4 = Splitter.on(CharMatcher.anyOf(",./"))
				.splitToList(src);//toList
		System.out.println(split4);

	}

	private static void test1()
	{
		String src = "jjijij.j,jjijia/fjisfh,..j,./,m,/,.,";
		String[] split = src.split("[,./]", 0);
		System.out.println(Arrays.asList(split));

		Iterable<String> split1 = Splitter.on(CharMatcher.anyOf(",./")).split(src);
		System.out.println(split1);

		Iterable<String> split2 = Splitter.on(Pattern.compile("[,./]")).split(src);
		System.out.println(split2);
	}
}
