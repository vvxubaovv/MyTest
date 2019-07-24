package com.xubao.test.simpleTest.setTest;

import com.xubao.Log;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/4/4
 */
public class SetTest1
{

	static class A
	{
		private int i = 3;
		private String name;

		public A(int i, String name)
		{
			this.i = i;
			this.name = name;
		}

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
					", name='" + name + '\'' +
					'}';
		}
	}

	public static void main(String[] args)
	{
		A a1 = new A(1, "a1");
		A a2 = new A(2, "a2");
		A a3 = new A(3, "a3");
		Set<A> aSet = new HashSet();
		aSet.add(a1);
		aSet.add(a2);
		aSet.add(a3);

		System.out.println(a1.equals(a2));
		System.out.println("a1=" + a1.hashCode());
		System.out.println("a2=" + a2.hashCode());
		System.out.println(aSet);
		a1.setI(2);
		a3.setI(2);
		//set不能添加相同元素,但如果元素可变,则可能存在相同元素
		Log.log("a1 equal a2 {},a2 equal a3 {}", a1.equals(a2), a2.equals(a3));
		System.out.println("a1=" + a1.hashCode());
		System.out.println("a2=" + a2.hashCode());
		System.out.println(aSet);
		System.out.println(aSet.size());

		A aa2 = new A(2);
		aSet.remove(aa2);//只会移除一个 而且是加入时就是2的元素
		System.out.println(aSet);
		System.out.println(aSet.size());

		aSet.remove(aa2);
		System.out.println(aSet);//移除不掉了

		A aa1 = new A(1);
		aSet.remove(aa1);
		System.out.println(aSet);//还是无法移除a1
	}
}
