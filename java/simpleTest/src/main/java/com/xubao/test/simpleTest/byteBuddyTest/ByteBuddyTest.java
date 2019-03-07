package com.xubao.test.simpleTest.byteBuddyTest;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/2/14
 */
public class ByteBuddyTest
{
	public static void main(String[] args) throws IllegalAccessException, InstantiationException
	{
		ByteBuddyAgent.install();
		A a = new A();
		B b = new B();
		a.print();
		b.print();
		System.out.println("-------------------");
		System.out.println(A.class.getName());
		//通过全
		new ByteBuddy()
				.redefine(B.class)
				.name("com.xubao.test.simpleTest.byteBuddyTest.ByteBuddyTest$A")
				.make()
				.load(ByteBuddyTest.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());

		A a1 = new A();
		System.out.println("a1");
		a1.print();
		System.out.println("a1---");

//		ByteBuddy byteBuddy = new ByteBuddy();
//				byteBuddy.redefine(C.class)
//				.name(B.class.getName())
//				.make()
//				.load(B.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());
//
//		byteBuddy.redefine(B.class)
//				.name(A.class.getName())
//				.make()
//				.load(B.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());

		a.print();
		b.print();
//		Class<?> dynamicType = new ByteBuddy()
//				.subclass(Object.class)
//				.method(ElementMatchers.named("toString"))
//				.intercept(FixedValue.value("Hello World!"))
//				.make()
//				.load(ByteBuddyTest.class.getClassLoader())
//				.getLoaded();
//
//		Object o = dynamicType.newInstance();
//		System.out.println(o.toString());
	}

	static class A
	{
		public void print()
		{
			System.out.println("A");
		}

//		public void print(String x){
//			System.out.println("x:"+x);
//		}
	}

	static class B
	{
		public void print()
		{
			System.out.println("B");
		}

//		public void print(String x){
//			System.out.println("x:"+x);
//		}
	}

	static class C
	{
		public void print()
		{
			System.out.println("C");
		}

//		public void print(String x){
//			System.out.println("x:"+x);
//		}
	}
}
