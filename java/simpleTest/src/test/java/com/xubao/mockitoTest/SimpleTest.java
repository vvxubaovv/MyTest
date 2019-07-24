package com.xubao.mockitoTest;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import java.util.List;

public class SimpleTest
{
	@Test
	public void test1()
	{
		List mock = Mockito.mock(List.class);
		mock.add("a");
		mock.add("b");
		List spy = Mockito.spy(mock);
		Mockito.when(spy.size()).thenReturn(11111);
		System.out.println(mock);
		System.out.println(spy.size());
	}
}
