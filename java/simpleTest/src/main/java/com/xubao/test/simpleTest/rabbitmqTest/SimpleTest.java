package com.xubao.test.simpleTest.rabbitmqTest;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class SimpleTest
{
	public static void main(String[] args) throws IOException, TimeoutException
	{
		ConnectionFactory factory = new ConnectionFactory();
//		factory.setUsername(userName);
//		factory.setPassword(password);
//		factory.setVirtualHost(virtualHost);
		factory.setHost("192.168.1.185");
		factory.setPort(5672);

		Connection connection = factory.newConnection();

		//2、声明通道
		Channel channel = connection.createChannel();
		//3、声明(创建)队列
		channel.queueDeclare("hello", false, false, false, null);
		//4、定义消息内容
		String message = "hello rabbitmq ";
		//5、发布消息
		channel.basicPublish("", "hello", null, message.getBytes());
		System.out.println("[x] Sent'" + message + "'");
		//6、关闭通道和连接
		channel.close();
		connection.close();
	}
}
