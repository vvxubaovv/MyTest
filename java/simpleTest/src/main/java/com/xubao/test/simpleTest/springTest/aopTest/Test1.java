package com.xubao.test.simpleTest.springTest.aopTest;

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
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean/aopTest.xml");

		A a = context.getBean(A.class);
		a.printA();
		a.printA1();
		A.printA2();
	}

}
