package com.xubao.test.simpleTest.toolkitTest;


import javax.swing.event.MouseInputAdapter;
import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;
import java.awt.event.AWTEventListener;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/3/30
 */
public class ToolKitTest
{
	public static void main(String[] args) throws InterruptedException
	{
		int i = 0;
		System.out.println(0xff);
		System.out.println(0x00ff);
		System.out.println(0xff00);
		//System.out.println(-38<<);
		while(i<100000)
		{
			//获取鼠标位置
			//System.out.println(System.currentTimeMillis());
			Point point = java.awt.MouseInfo.getPointerInfo().getLocation();
			//System.out.println(System.currentTimeMillis());
			System.out.println(point.x+":"+point.y);
			Thread.sleep(100);
		}

	}
}
