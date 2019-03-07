package com.xubao.test.simpleTest.fastjsonTest;

import com.alibaba.fastjson.JSONObject;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/11/29
 */
public class FastjsonTest
{
	public static void main(String[] args)
	{
		byte[] bytes = "abcdef48484844844dddddddddddddddddddddddddddddggggggggggggggggggggggeeeeeeeeeeeeeeeeeeeeeeeeeeeeggggggggggggggggggggggggggggssssssssssssssss".getBytes();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("bytes", bytes);

		String s = jsonObject.toJSONString();//bytes会转换为base64
		System.out.println(s);
	}
}
