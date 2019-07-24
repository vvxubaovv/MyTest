package com.xubao.junitTestTest.runWithTest.forCategoryTest;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class A
{
	@Test
	@Category({Tag1.class, Tag2.class})
	public void a()
	{
		System.out.println("A a");
	}

	@Category({Tag2.class, Tag3.class})
	@Test
	public void b()
	{
		System.out.println("A b");
	}

	@Test
	@Category({Tag3.class})
	public void c()
	{
		System.out.println("A c");
	}
}
