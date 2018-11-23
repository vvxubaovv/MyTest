package com.xubao.test.simpleTest.genericityTest;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/10/23
 */
public class VoidImp implements IVoid<Void>
{
	@Override
	public Void get()
	{
		//return "jjjjj";编译器报错
		return null;//正确
	}
}
