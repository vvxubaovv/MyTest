package com.xubao.test.simpleTest.java8Test;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/11/16
 */
public class Main
{
	public static void main(String[] args)
	{
		// :: 可理解为函数对象表达
		// 编译器可自动封装函数为实现对应接口的匿名对象  对应接口只能有一个待实现的方法
		// 主要表达 将对应操作封装为特定对象

		//A的静态方法x
		xx(A::x, 2);//会被转化为函数接口对象,相当于自动用接口包装

		//A对象的方法
		xx(new A("11111")::xxxx, 4);//can work !!!!!

		A a = new A("22222222");

		//表达对A类型进行yy方法的调用操作
		//test方法的第一个入参为A对像,第二个为yy函数入参
		ObjTest<A, String> objTest = A::yy;
		objTest.test(a, "jiji");

		//错误 只表达a的方法
		//ObjTest<A, String> objTest1 = a::yy;

		//只要B接口的方法类型匹配即可
		B b = A::yy;
		b.b(new A("33333"), "hahahah");

		//提示C is no a function interface
		//必须要是只有一个待实现方法的接口
//		C c = A::yy;

		D d = Object::new; //匹配构造方法 Object()

		E e = A::new;   //匹配构造方法 A(String index)
	}

	public static void xx(ITest iTest, int x)
	{
		iTest.test(x);
	}

	public static class A
	{
		private String index;

		public A(String index)
		{
			this.index = index;
		}

		public static void x(int b)
		{
			System.out.println("x--" + b);
		}

		public void xxxx(int c)
		{
			System.out.println(index + "-----xxxx---" + c);
		}

		public void yy(String a)
		{
			System.out.println(index + "-----yy---" + a);
		}
	}

	interface B
	{
		void b(A a, String s);
	}

	abstract class C
	{
		abstract void c(A a, String s);
	}

	interface D
	{
		void d();
	}

	interface E
	{
		void e(String e);
	}
}
