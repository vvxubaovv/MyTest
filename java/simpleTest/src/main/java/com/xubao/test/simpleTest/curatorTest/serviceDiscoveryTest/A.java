package com.xubao.test.simpleTest.curatorTest.serviceDiscoveryTest;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/2/26
 */
public class A
{
	public int a;
	public String b;

	public int getA()
	{
		return a;
	}

	public void setA(int a)
	{
		this.a = a;
	}

	public String getB()
	{
		return b;
	}

	public void setB(String b)
	{
		this.b = b;
	}

	@Override
	public String toString()
	{
		return "A{" +
				"a=" + a +
				", b='" + b + '\'' +
				'}';
	}
}
