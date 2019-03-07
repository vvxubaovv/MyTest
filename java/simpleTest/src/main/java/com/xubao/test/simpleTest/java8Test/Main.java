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
		xx(A::x,2);//会被转化为函数接口对象,相当于自动用接口包装

		xx(new A()::xxxx,4);//can work !!!!!
	}

	public static void xx(ITest iTest,int x){
		iTest.test(x);
	}

	public static class A{
		public static void x(int b){
			System.out.println("x--"+b);
		}

		public void xxxx(int c){
			System.out.println("xxxx---"+c);
		}
	}
}
