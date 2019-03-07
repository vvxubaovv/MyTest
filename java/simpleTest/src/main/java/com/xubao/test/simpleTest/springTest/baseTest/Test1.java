package com.xubao.test.simpleTest.springTest.baseTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/2/25
 */
public class Test1
{
	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean/baseTest.xml");
		A bean = context.getBean(A.class);
		System.out.println(bean);

		//prototype 每次返回不同
		Test1 bean1 = context.getBean(Test1.class);
		Test1 bean2 = context.getBean(Test1.class);
		System.out.println(bean1 == bean2);

		//prototype 每次返回不同
		B b1 = context.getBean(B.class);
		B b2 = context.getBean(B.class);
		System.out.println(b1 == b2);
	}

	@Bean
	public A a()
	{
		return new A();
	}

	public static class A
	{

	}

	public static B b;

	public B b()
	{
		System.out.println("调用b()");
		if(b == null)
		{
			b = new B();
		}
		return b;
	}

	public static class B
	{

	}
}
