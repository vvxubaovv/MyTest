package com.xubao.test.simpleTest.hystrixTest;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import rx.Observable;

import java.util.concurrent.Future;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/10/31
 */
public class CommandHelloWorld extends HystrixCommand<String>
{

	private final String name;

	public CommandHelloWorld(String name) {
		super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup")); //必须
		this.name = name;
	}

	@Override
	protected String run() {
        /*
         网络调用 或者其他一些业务逻辑，可能会超时或者抛异常
        */
		return "Hello " + name + "!";
	}

	public static void main(String[] args)
	{
		String s = new CommandHelloWorld("Bob").execute(); //
		System.out.println(s);
		Future<String> f = new CommandHelloWorld("Bob").queue();
		Observable<String> obs = new CommandHelloWorld("Bob").observe();
		Observable<String> toObservable = new CommandHelloWorld("Bob").toObservable();
	}
}

