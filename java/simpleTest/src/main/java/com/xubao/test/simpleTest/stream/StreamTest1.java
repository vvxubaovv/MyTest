package com.xubao.test.simpleTest.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/10/11
 */
public class StreamTest1
{
	public static void main(String[] args)
	{
		test1();
		test2();
		test3();
		test4();
	}

	private static void test4()
	{
		List<String> strList = Arrays.asList("123","1233","12333","123333","1233333");
		String res = strList.stream().reduce("ff", (a, b) -> a + "-" + b);
		System.out.println(res);
	}

	private static void test3()
	{
		List<String> strList = Arrays.asList("123","1233","12333","123333","1233333");
		List<String> collect = strList.stream().collect(Collectors.toList());
		System.out.println(collect);

		Map<Boolean, List<String>> collect1 = strList.stream().collect(Collectors.groupingBy(str -> str.length() > 3));
		System.out.println(collect1);//{false=[123], true=[1233, 12333, 123333, 1233333]}

		//两级分类,在一级基础上的两级分类
		Map<Boolean, Map<Boolean, List<String>>> collect2 = strList.stream().collect(Collectors.groupingBy(str -> str.endsWith("33"), Collectors.groupingBy(str -> str.length() > 5)));
		System.out.println(collect2);//{false={false=[123]}, true={false=[1233, 12333], true=[123333, 1233333]}}

		Map<String, List<String>> collect3 = strList.stream().collect(Collectors.groupingBy(str -> str.substring(str.length()-3,str.length())));
		System.out.println(collect3);//{233=[1233], 123=[123], 333=[12333, 123333, 1233333]}


	}

	private static void test1()
	{
		//流相当于将多个操作结合到一起,最后需要结果时统一计算
		List<String> strList = Arrays.asList("123","1233","12333","123333","1233333");
		Stream<String> stringStream = strList.stream().filter(str -> str.startsWith("1233"));
		Stream<String> stringStream1 = stringStream.filter(str -> str.endsWith("333"));
		//long count = stringStream.count();//流有了其他操作,相当于流过了,不能在进行其他操作
		Optional<String> any = stringStream1.findAny();
		String s = any.get();

	}

	private static void test2()
	{
		//流相当于将多个操作结合到一起,最后需要结果时统一计算
		List<String> strList = Arrays.asList("123","1233","12333","123333","1233333");

		Optional<String> collect = strList.stream().collect(Collectors.maxBy((a, b) -> a.length() - b.length()));
		String s = collect.get();
	}
}
