package com.xubao.test.simpleTest.setTest;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/4/4
 */
public class SetTest1
{

	static class A{
		private int i = 3;

		public A(int i)
		{
			this.i = i;
		}

		public int getI()
		{
			return i;
		}

		public void setI(int i)
		{
			this.i = i;
		}

		@Override
		public boolean equals(Object o)
		{
			if(this == o) return true;
			if(o == null || getClass() != o.getClass()) return false;

			A a = (A)o;

			return i == a.i;
		}

		@Override
		public int hashCode()
		{
			return i;
		}

		@Override
		public String toString()
		{
			return "A{" +
					"i=" + i +
					'}';
		}
	}

	public static void main(String[] args){
		A a1 = new A(1);
		A a2 = new A(2);
		Set<A> aSet = new HashSet<A>();
		aSet.add(a1);
		aSet.add(a2);

		System.out.println(a1.equals(a2));
		System.out.println("a1="+a1.hashCode());
		System.out.println("a2="+a2.hashCode());
		System.out.println(aSet);
		a2.setI(1);
		//set不能添加相同元素,但如果元素可变,则可能存在相同元素
		System.out.println(a1.equals(a2));
		System.out.println("a1="+a1.hashCode());
		System.out.println("a2="+a2.hashCode());
		System.out.println(aSet);

	}
}
