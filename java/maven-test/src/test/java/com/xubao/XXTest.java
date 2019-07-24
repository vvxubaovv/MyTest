package com.xubao;

import org.junit.Test;

public class XXTest
{
	@Test
	public void test()
	{
		//mvn test -Dxx.xx=jjj
		System.out.println("----------------");
		System.out.println(System.getProperty("xx.xx"));
	}
}
