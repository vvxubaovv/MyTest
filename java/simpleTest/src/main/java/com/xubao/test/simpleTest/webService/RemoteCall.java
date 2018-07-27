package com.xubao.test.simpleTest.webService;

import com.xubao.test.simpleTest.webService.remote.Info;
import com.xubao.test.simpleTest.webService.remote.RpcTestService;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/7/27
 */
public class RemoteCall
{
	public static void main(String[] args)
	{
		RpcTestService rpcTestService = new RpcTestService();
		com.xubao.test.simpleTest.webService.remote.RpcTest rpcTestPort = rpcTestService.getRpcTestPort();
		rpcTestPort.hello("xubao");
		String xubao1 = rpcTestPort.nihao("xubao1");
		System.out.println(xubao1);

		Info info = new Info();
		info.setName("xubao");
		info.setAge(111);
		info.setSex("nanan");
		info.getFriend().add("1111");
		info.getFriend().add("2222");
		rpcTestPort.setInfo(info);

		System.out.println("----------------------------");

		Info xubao = rpcTestPort.getInfo("xubao");
		System.out.println(xubao);
	}
}
