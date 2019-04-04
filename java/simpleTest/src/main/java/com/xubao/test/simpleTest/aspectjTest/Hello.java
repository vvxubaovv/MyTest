package com.xubao.test.simpleTest.aspectjTest;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/4/3
 */

	public class Hello {
		public void sayHello() {
			System.out.println("Hello, AspectJ!");
		}

		public static void main(String[] args) {
			Hello hello = new Hello();
			hello.sayHello();
		}
	}

