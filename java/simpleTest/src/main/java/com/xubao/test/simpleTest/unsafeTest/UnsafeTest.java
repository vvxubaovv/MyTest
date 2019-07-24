package com.xubao.test.simpleTest.unsafeTest;

import com.xubao.Log;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/5/17
 */
public class UnsafeTest
{
	public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException
	{
		makeObj();

		offHeapMemory();
	}

	private static void offHeapMemory() throws IllegalAccessException, NoSuchFieldException, InstantiationException
	{
		Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
		theUnsafe.setAccessible(true);
		Unsafe unsafe = (Unsafe)theUnsafe.get(theUnsafe);

		long addr = unsafe.allocateMemory(1024);
		Log.log("addr:{}", addr);
		byte aByte = unsafe.getByte(addr+3);
		Log.log("byte:{}", aByte);


		unsafe.putByte(addr+3,(byte)5);
		byte bbyte = unsafe.getByte(addr+3);
		Log.log("byte:{}", bbyte);

		byte dd = unsafe.getByte(addr+12323000);
		Log.log("byte:{}",dd);

		unsafe.freeMemory(addr);//释放
	}

	private static void makeObj() throws IllegalAccessException, NoSuchFieldException, InstantiationException
	{
		Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
		theUnsafe.setAccessible(true);
		Unsafe unsafe = (Unsafe)theUnsafe.get(theUnsafe);

		A a1 = new A();
		Log.log("a1:{}", a1);

		A a2 = A.class.newInstance();
		Log.log("a2:{}", a2);

		A a3 = (A)unsafe.allocateInstance(A.class);//跳过了构造方法的执行
		Log.log("a3:{}", a3);


	}


	private static void changeField() throws NoSuchFieldException, IllegalAccessException
	{
		Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
		theUnsafe.setAccessible(true);
		Unsafe unsafe = (Unsafe)theUnsafe.get(theUnsafe);

		A a = new A(2);

		Log.log("初始化 a={}", a);

		long offset = unsafe.objectFieldOffset(A.class.getDeclaredField("a"));
		Log.log("offset:{}", offset);

		//compareAndSwapInt 原子操作
		boolean succ = unsafe.compareAndSwapInt(a, offset, 2, 13);
		Log.log("succ:{}", succ);

		Log.log("设置后 a={}", a);
	}

	static class A
	{
		private int b;
		private int a;

		public A()
		{
			a = -1;
			b = -1;
		}

		public A(int a)
		{
			this.a = a;
		}

		@Override
		public String toString()
		{
			return "A{" +
					"b=" + b +
					", a=" + a +
					'}';
		}
	}
}
