package com.xubao.test.simpleTest.jniTest;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/3/8
 */
public class JniTest
{
	public native String echo(String str);

	JniTest()
	{
		String jniTest = LibUtils.copyLib("jniTest");
		System.out.println(jniTest);
		System.load(jniTest);
	}

	public static void main(String[] args)
	{
		int x = 10;
		for(int i = 0; i < x; i++)
		{
			JniTest jniTest1 = new JniTest();
			System.out.println(jniTest1.echo("jijiji----" + i));
		}
	}
}
