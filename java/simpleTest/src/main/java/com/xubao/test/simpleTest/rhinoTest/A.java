package com.xubao.test.simpleTest.rhinoTest;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/10/12
 */
public class A
{
	private String a;
	public String a1;
	public static String SA = "3";
	public A()
	{
	}

	public A(String a)
	{
		this.a = a;
	}

	public String getA()
	{
		return a;
	}

	public void setA(String a)
	{
		this.a = a;
	}

	public String getA1()
	{
		return a1;
	}

	public void setA1(String a1)
	{
		this.a1 = a1;
	}

	public static String getSA()
	{
		return SA;
	}

	public static void setSA(String SA)
	{
		A.SA = SA;
	}

	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		A a1 = (A)o;

		return a != null ? a.equals(a1.a) : a1.a == null;
	}

	@Override
	public int hashCode()
	{
		return a != null ? a.hashCode() : 0;
	}

	@Override
	public String toString()
	{
		return "A{" +
				"a='" + a + '\'' +
				", a1='" + a1 + '\'' +
				'}';
	}
}

class B{
	public static final String SB = "sb";
}
