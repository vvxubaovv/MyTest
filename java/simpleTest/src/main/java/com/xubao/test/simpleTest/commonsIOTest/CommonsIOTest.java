package com.xubao.test.simpleTest.commonsIOTest;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/3/7
 */
public class CommonsIOTest
{
	public static void main(String[] args) throws IOException
	{
		FileUtils.deleteQuietly(new File("z://a.txt"));
		FileUtils.deleteDirectory(new File("z://Everything-1.4.1.935.x64"));
	}
}
