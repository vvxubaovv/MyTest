package com.xubao.test.simpleTest.hystrixTest;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;

import java.util.concurrent.TimeUnit;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/10/31
 */
public class CommandHelloWorld1 extends HystrixCommand<String>
{

	private final String name;

	static Setter set=Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))  //必须
			.andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ExampleGroup-pool"))  //可选,默认 使用 this.getClass().getSimpleName();
		.andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(4));
	public CommandHelloWorld1(String name) {
		super(set);

		this.name = name;
	}

	@Override
	protected String run() throws InterruptedException {
		System.out.println("running");
		TimeUnit.MILLISECONDS.sleep(1000);
		return "Hello " + name + "!";
	}

	@Override
	protected String getFallback()
	{
		return "xx . xx .xx";
	}

	public static void main(String[] args)
	{
		CommandHelloWorld1 commandHelloWorld1 = new CommandHelloWorld1("xb");
		String str = commandHelloWorld1.execute();
		System.out.println(str);
	}
}
