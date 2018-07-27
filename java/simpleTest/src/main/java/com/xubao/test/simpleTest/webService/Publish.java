package com.xubao.test.simpleTest.webService;

import javax.xml.ws.Endpoint;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/7/27
 */
public class Publish
{
	//wsimport -s z:\temp\s -d z:\temp\d -p com.xubao.test.simpleTest.webService.remote -keep -encoding utf8 http://192.168.1.52:9002/rpcTest?wsdl
	public static void main(String[] args)
	{
		IRpcTest rpcTest = new RpcTest();
		Endpoint.publish("http://0.0.0.0:9002/rpcTest", rpcTest);
		System.out.println("开启");
	}
}
