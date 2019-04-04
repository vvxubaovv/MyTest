package com.xubao.test.simpleTest.springTest.aopTest;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/2/25
 */
public class Time
{
	private static int x = 0;

	public void printTime()
	{
		System.out.println(System.currentTimeMillis());
	}

	public Object arroundPrintTime(ProceedingJoinPoint point)//around增强时可以没有
	{
		System.out.println("开始x:" + x);
		Object rult = null;
		try
		{
			rult = point.proceed();//在此执行原始方法
		}
		catch(Throwable throwable)
		{
			throwable.printStackTrace();
		}
		System.out.println("返回结果:" + rult);

		System.out.println("结束:x" + x);
		x++;

		return 1;//有返回值的必须返回相同类型对象,否则报错, 没有返回值的可返回可不返回,不报错反正没有意义
	}

	public Object withTag()
	{
		System.out.println("withTag");
		return 1;
	}

	public Object withTagCount(int count)
	{
		System.out.println("withTagCount " + count);
		return 1;
	}

	public Object withTagCount2(int count, int a)
	{
		System.out.println("withTagCount " + count + "  a=" + a);
		return 1;
	}

	public Object withTagAroundCount2(ProceedingJoinPoint point, int a, int count) throws Throwable
	{
		System.out.println("start withTagAroundCount " + count + "  a=" + a);
		Object proceed = point.proceed();
		System.out.println("end withTagAroundCount " + count + "  a=" + a);
		return proceed;
	}

	public Object forArgs(int a)
	{
		System.out.println("forArgs a:" + a);
		return 1;
	}
}
