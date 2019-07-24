package com.xubao.test.simpleTest.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/10/11
 */
public class StreamTest1
{
	//collector 表示对流进行最终的处理
	//

	public static void main(String[] args)
	{
//		test1();
//		test2();
//		test3();
		test4();
//		test5();
//		test6();
//		test7();
//		test8();
//		test9();
	}

	private static void test9()
	{
		List<String> list = new ArrayList<>();
		Random random = new Random(223);
		int count = 100000;
		for(int i = 0; i < count; i++)
		{
			list.add(random.nextInt() + "");
		}

		long start = System.nanoTime();
		int z = 0;

		int sleep = 0;

		for(String s : list)
		{
			z += Integer.parseInt(s);
			try
			{
				Thread.sleep(sleep);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		long end = System.nanoTime();
		System.out.println("for   :" + (end - start));

		start = System.nanoTime();
		int q[] = new int[1];
		list.stream()/*.map((s) -> s + "0")*//*.sorted(Comparator.comparingInt(Integer::parseInt))*/.forEach((x) ->
		{
			q[0] += Long.parseLong(x);
			try
			{
				Thread.sleep(sleep);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		});
		end = System.nanoTime();
		System.out.println("stream:" + (end - start));

	}

	private static void test8()
	{
		List<String> list = Arrays.asList("1", "11", "3", "10", "12", "21", "22", "211", "1111");
		List<String> collect = list.stream().limit(5).collect(Collectors.toList());
		System.out.println(collect);

		collect = list.stream().filter((x)->x.contains("3")).sorted(Comparator.comparingInt((x) -> -Integer.parseInt(x))).limit(5).collect(Collectors.toList());
		System.out.println(collect);
	}

	private static void test7()
	{
		//分割为一个一个字符
		String[] split = "1234567890".split("");
		List<String> list = Arrays.asList(split);
		Map<Integer, String> collect = list.stream().collect(Collectors.<String, Integer, String>toMap(key -> Integer.parseInt(key) + 1000, v -> v));
		System.out.println(collect);

		Map<String, String> collect1 = list.stream().collect(Collectors.toMap(key -> key + 1000, v -> v));
		System.out.println(collect1);


		//找最大
		Optional<String> max = list.stream().max((a, b) -> Integer.parseInt(a) - Integer.parseInt(b));
		System.out.println(max);

		//不执行 peek
		list.stream().limit(3).peek(o -> System.out.println("peek:" + o));

		//执行 peek
		Long count = list.stream().limit(3).peek(o -> System.out.println("peek:" + o)).collect(Collectors.counting());
		System.out.println(count);

		Stream.iterate("xx", o -> "---" + o).peek(o -> System.out.println("peek:" + o)).count();
	}

	private static void test6()
	{
		List<String> collect = Stream.of(Arrays.asList("123"),
				Arrays.asList("456"),
				Arrays.asList(1, 2)).flatMap((a) -> a.stream().map(o->o.toString())).collect(Collectors.toList());

//		List<String> collect = Stream.of(Arrays.asList("123"),
//				Arrays.asList("456"),
//				Arrays.asList(1, 2)).flatMap((a) -> Stream.<String>empty()).collect(Collectors.toList());

		System.out.println(collect);
	}

	private static void test5()
	{
		List<String> strList = Arrays.asList("123", "1233", "12333", "123333", "1233333");
		//将元素进行一一映射
		List<Integer> ll = strList.stream().map(a ->
		{
			return Integer.parseInt(a);
		}).collect(Collectors.toList());
		System.out.println(ll);
	}

	private static void test4()
	{
//		List<String> strList = Arrays.asList("123", "1233", "12333", "123333", "1233333");
//		String res = strList.stream().reduce("ff", (a, b) -> a + "-" + b);
//		System.out.println(res);

		List<String> strList = Arrays.asList("11");//Arrays.asList("123", "1233", "12333", "123333", "1233333");
		String res = strList.stream().reduce(null, (a, b) -> a + "-" + b);
		System.out.println(res);
	}

	private static void test3()
	{
		List<String> strList = Arrays.asList("123", "1233", "12333", "123333", "1233333");
		List<String> collect = strList.stream().collect(Collectors.toList());
		System.out.println(collect);

		Map<Boolean, List<String>> collect1 = strList.stream().collect(Collectors.groupingBy(str -> str.length() > 3));
		System.out.println(collect1);//{false=[123], true=[1233, 12333, 123333, 1233333]}

		//两级分类,在一级基础上的两级分类
		Map<Boolean, Map<Boolean, List<String>>> collect2 = strList.stream().collect(Collectors.groupingBy(str -> str.endsWith("33"), Collectors.groupingBy(str -> str.length() > 5)));
		System.out.println(collect2);//{false={false=[123]}, true={false=[1233, 12333], true=[123333, 1233333]}}

		Map<String, List<String>> collect3 = strList.stream().collect(Collectors.groupingBy(str -> str.substring(str.length() - 3, str.length())));
		System.out.println(collect3);//{233=[1233], 123=[123], 333=[12333, 123333, 1233333]}


	}

	private static void test1()
	{
		//流相当于将多个操作结合到一起,最后需要结果时统一计算
		List<String> strList = Arrays.asList("123", "1233", "12333", "123333", "1233333");
		Stream<String> stringStream = strList.stream().filter(str -> str.startsWith("1233"));
		Stream<String> stringStream1 = stringStream.filter(str -> str.endsWith("333"));
		//long count = stringStream.count();//流有了其他操作,相当于流过了,不能在进行其他操作
		Optional<String> any = stringStream1.findAny();
		String s = any.get();

	}

	private static void test2()
	{
		//流相当于将多个操作结合到一起,最后需要结果时统一计算
		List<String> strList = Arrays.asList("123", "1233", "12333", "123333", "1233333");

		Optional<String> collect = strList.stream().collect(Collectors.maxBy((a, b) -> a.length() - b.length()));
		String s = collect.get();
	}
}
