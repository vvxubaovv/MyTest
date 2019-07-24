package com.xubao.test.simpleTest.ioTest.nioTest;

import java.nio.ByteBuffer;

public class BufferTest
{
	public static void main(String[] args)
	{
		ByteBuffer buf = ByteBuffer.allocate(25);
		System.out.println(buf);//pos=0 lim=25 cap=25
		buf.put("123456".getBytes());
		System.out.println(buf);//pos=6 lim=25 cap=25

		byte[] bytes = new byte[6];
		buf.get(bytes);//导致pos变大 取到pos后几位的 无效数据或空数据
		System.out.println(new String(bytes));
		System.out.println(buf);

		buf.flip();
		System.out.println(buf);
		buf.flip();
		System.out.println(buf);

		//不管读或写 pos变大 pos 从到 pos 到 pos+n
		//写两个 写到pos 和pos+1上
		//读两个 读到pos 和pos+1上
		//flip limit=pos  pos=0
		//连续两次flip 导致limit=0 pos=0  导致不可写 不可读 需要reset

	}
}
