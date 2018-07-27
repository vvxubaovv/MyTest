package com.xubao.test.simpleTest.gc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/6/13
 */
public class GC
{
	public static void main(String[] args)
	{
		bigObjTest();
	}

	public static void bigObjTest()
	{
		List<byte[]> ints = new ArrayList<byte[]>();
		Scanner sc = new Scanner(System.in);
		int size = 1;
		while(size > 0)
		{
			System.out.print("输入:");
			size = sc.nextInt();
			try
			{
				byte[] temp = new byte[size];
//				for(int i = 0;i<temp.length;i++){
//					temp[i] = i;
//					//Thread.sleep(100);
//				}
				ints.add(temp);
			}
			catch(Throwable t)
			{
				t.printStackTrace();
			}
			int count = 0;
			for(byte[] arr : ints)
			{
				count += arr.length;
			}
			System.out.println("length=" + ints.size() + "  memery=" + (count*4) + "b");
		}
	}
}
