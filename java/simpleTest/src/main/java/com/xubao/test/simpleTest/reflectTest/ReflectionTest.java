//package com.xubao.test.simpleTest.reflectTest;
//
//import com.xubao.ForReflectionTest;
//import sun.reflect.Reflection;
//
//import java.util.Arrays;
////按委托加载规则,加载的是 jre ext 中 jar 里面 的 com.xubao.ForReflectionTest 类
////但本地必须有com.xubao.ForReflectionTest,否则编译不过
//
///**
// * @author xubao
// * @version 1.0
// * @since 2019/5/16
// */
//public class ReflectionTest
//{
//
//	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException
//	{
//		testSecurityManager();
//		reflectionTest1();
//
//		reflectionTest2(-1);
//		reflectionTest2(0);
//		reflectionTest2(1);
//		reflectionTest2(2);
//		reflectionTest2(3);
//	}
//
//
//	private static void reflectionTest2(int i)
//	{
//		System.out.println(Reflection.getCallerClass(i));
//	}
//
//	private static void reflectionTest1()
//	{
//		//Class<?> callerClass = Reflection.getCallerClass();//报错
//		//System.out.println(callerClass.getName());
//
//		ForReflectionTest test = new ForReflectionTest();
//		System.out.println("ForReflectionTest classLoader:" + ForReflectionTest.class.getClassLoader() + " parent:" + ForReflectionTest.class.getClassLoader().getParent());
//		test.printX();
//		System.out.println("ReflectionTest classLoader:" + ReflectionTest.class.getClassLoader() + " parent:" + ReflectionTest.class.getClassLoader().getParent());
//		System.out.println("System classLoader:" + System.class.getClassLoader());
//	}
//
//	static class A
//	{
//		public void printA()
//		{
//			System.out.println("A :" + Reflection.getCallerClass());
//		}
//	}
//
//	private static void testSecurityManager()
//	{
//		new SecurityManager()
//		{
//			{
//				String name = getClassContext()[1].getSimpleName();
//				System.err.println(name == null ? "null" : name);
//
//				Class[] classContext = getClassContext();
//				System.out.println(Arrays.asList(classContext));
//			}
//		};
//	}
//}
