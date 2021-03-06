package com.xubao.test.simpleTest.springTest.aopTest;

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
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean/aopTest.xml");

		A a = context.getBean(A.class);
		a.printA();
		a.printA1();
		A.printA2();
		a.printA3(3);
		a.printA4(4);
		a.printA5(5,2);
		a.printA6("6");

		A.B b = context.getBean(A.B.class);
		b.printB();
		b.printB1();

		System.out.println("----------------------------------------------------------------------");
		F bean = context.getBean(F.class);
		bean.printF1();

		F instance = F.instance();
		instance.printF1();
	}

}
