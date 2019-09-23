package com.xubao.junit5Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;

@ExtendWith(ExtendWithTest.Extend.class)
public class ExtendWithTest
{
	public static class Extend implements Extension
	{

	}
}
