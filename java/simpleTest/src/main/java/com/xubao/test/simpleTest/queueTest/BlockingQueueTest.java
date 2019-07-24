package com.xubao.test.simpleTest.queueTest;

import com.xubao.Log;

import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTest
{
	public static void main(String[] args) throws InterruptedException
	{
//		test1();
		test2();
	}

	private static void test2() throws InterruptedException
	{
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(2);//传入容量 默认max int
		queue.put("1");
		queue.put("2");
		boolean succ = queue.add("3");//容量不够 直接报错 够则返回true
		String poll = queue.poll();//获取不阻塞
		Log.log("poll:{}", poll);
	}

	private static void test1() throws InterruptedException
	{
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(3);//传入容量 默认max int
		queue.put("1");
		queue.put("2");
		queue.put("3");
//		queue.put("4");//容量不够 一直阻塞
		String poll = queue.poll();//获取不阻塞
//		queue.poll(5, TimeUnit.SECONDS);//获取设置阻塞 没数据时阻塞
		Log.log("poll:{}", poll);

		String poll1 = queue.poll();
		Log.log("poll1:{}",poll1);
	}
}
