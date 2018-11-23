package com.xubao.test.simpleTest.genericityTest;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/10/23
 */
public interface IVoid<V>
{
	V get();

	public static void main(String[] args)
	{
		IVoid v = new VoidImp();
		System.out.println(v.get());
		IVoid v1 = new VoidImp1();
		System.out.println(v1.get());
	}
}
