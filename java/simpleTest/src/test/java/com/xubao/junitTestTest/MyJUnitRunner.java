package com.xubao.junitTestTest;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyJUnitRunner extends BlockJUnit4ClassRunner
{
	public static List<String> excludeTag;

	static
	{
		String excludeTag1 = System.getProperty("excludeTag");
		if(excludeTag1 == null)
		{
			excludeTag = Collections.emptyList();
		}
		else
		{
			excludeTag = Arrays.asList(excludeTag1.split(","));
		}
	}

	protected boolean ignoreAll = false;

	public MyJUnitRunner(Class<?> testClass) throws InitializationError
	{
		super(testClass);

		MyIgnore annotation1 = getDescription().getAnnotation(MyIgnore.class);
		if(annotation1 != null)
		{
			for(String tag : annotation1.tag())
			{
				if(excludeTag.contains(tag))
				{
					ignoreAll = true;
					break;
				}
			}
		}
	}

	@Override
	protected boolean isIgnored(FrameworkMethod child)
	{
		if(super.isIgnored(child))
		{
			return true;
		}

		if(ignoreAll)
		{
			return true;
		}

		MyIgnore annotation = child.getAnnotation(MyIgnore.class);
		if(annotation == null)
		{
			return false;
		}

		for(String tag : annotation.tag())
		{
			if(excludeTag.contains(tag))
			{
				return true;
			}
		}
		return false;
	}
}
