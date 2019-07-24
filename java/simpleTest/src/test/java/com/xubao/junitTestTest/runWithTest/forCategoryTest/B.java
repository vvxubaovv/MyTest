package com.xubao.junitTestTest.runWithTest.forCategoryTest;

import org.junit.Test;
import org.junit.experimental.categories.Category;
//import org.junit.jupiter.api.Test;切勿导入这个Test

@Category({Tag3.class})
public class B
{
	@Test
	public void a()
	{
		System.out.println("B a");
	}

	@Test
	public void b()
	{
		System.out.println("B b");
	}

	@Test
	public void c()
	{
		System.out.println("B c");
	}
}
