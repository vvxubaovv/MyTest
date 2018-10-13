package com.test.rxjava;

import io.reactivex.*;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/8/30
 */
public class First
{
	public static void main(String[] args) throws IOException
	{
		//fun1();
		//fun2();
		fun3();
	}

	private static void fun3() throws IOException
	{
		Flowable<Integer> integerFlowable = Flowable.create(new FlowableOnSubscribe<Integer>()
		{
			public void subscribe(FlowableEmitter<Integer> emitter) throws Exception
			{
				System.out.println("1");
				emitter.onNext(1);
				System.out.println("2");
				emitter.onNext(2);
				System.out.println(3);
				emitter.onNext(3);
			}
		}, BackpressureStrategy.ERROR);

		integerFlowable.subscribeOn(Schedulers.io()).subscribe(new Subscriber<Integer>()
		{
			Subscription subscription;
			public void onSubscribe(Subscription subscription)
			{
				System.out.println("onSubscribe");
				//subscription.request(1);
				this.subscription = subscription;
			}

			public void onNext(Integer integer)
			{
				System.out.println("onNext:"+integer);
				//subscription.request(1);
			}

			public void onError(Throwable throwable)
			{
				System.out.println("onError:"+throwable);
			}

			public void onComplete()
			{
				System.out.println("onComp");
			}
		});

		System.in.read();
	}

	private static void fun1(){
		final ObservableEmitter<Integer>[] emitter = new ObservableEmitter[1];
		Observable<Integer> integerObservable = Observable.create(new ObservableOnSubscribe<Integer>()
		{

			public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception
			{
				emitter[0] = e;
				e.onNext(1);
				e.onNext(2);
				e.onNext(3);
				//e.onComplete();
				e.onNext(4);
			}
		});
		integerObservable.subscribe(new Observer<Integer>()
		{
			private int i;
			private Disposable mDisposable;

			public void onSubscribe(@NonNull Disposable d)
			{
				System.out.println("onSubscribe");
			}

			public void onNext(@NonNull Integer integer)
			{
				System.out.println("onNext:"+integer);
			}

			public void onError(@NonNull Throwable e)
			{
				System.out.println("onError");
			}

			public void onComplete()
			{
				System.out.println("onComplete");
			}
		});

		Scanner scanner = new Scanner(System.in);

		int next = 0;
		while((next = scanner.nextInt()) != -1)
		{
			if(next==-2){
				emitter[0].onComplete();//结束事件发送
			}else if(next==-3){
				emitter[0].onError(new NullPointerException());//报错
			}
			emitter[0].onNext(next);//发送事件
		}
	}

	private static void fun2(){
		final List<ObservableEmitter<Integer>> emitterList = new ArrayList<ObservableEmitter<Integer>>();
		Observable<Integer> integerObservable = Observable.create(new ObservableOnSubscribe<Integer>()
		{

			public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception
			{
				System.out.println("subscribe");
				emitterList.add(e);
				e.onNext(1);
			}
		});
		Observable<String> map = integerObservable.map(new Function<Integer, String>()
		{
			public String apply(Integer integer) throws Exception
			{
				return "map :" + integer;
			}
		}).observeOn(Schedulers.newThread());

		map.subscribe(new Consumer<String>()
		{
			public void accept(String s)
			{
				System.out.println("s"+s);
				System.out.println(Thread.currentThread().getName());
			}
		});

		integerObservable.last(1000);


		integerObservable.subscribe(new Observer<Integer>()
		{
			private int i;
			private Disposable mDisposable;

			public void onSubscribe(@NonNull Disposable d)
			{
				System.out.println("onSubscribe");
			}

			public void onNext(@NonNull Integer integer)
			{
				System.out.println("onNext:"+integer);
				System.out.println(Thread.currentThread().getName());
			}

			public void onError(@NonNull Throwable e)
			{
				System.out.println("onError");
			}

			public void onComplete()
			{
				System.out.println("onComplete");
			}
		});

		map.subscribe(new Consumer<String>()
		{
			public void accept(String s) throws Exception
			{
				System.out.println("map sub:"+s);
				System.out.println(Thread.currentThread().getName());
			}
		});


		integerObservable.subscribeOn(Schedulers.newThread());
		map.subscribeOn(Schedulers.newThread());


		Scanner scanner = new Scanner(System.in);

		int next = 0;
		while((next = scanner.nextInt()) != -1)
		{
			if(next==-2){
				//emitter[0].onComplete();//结束事件发送
			}else if(next==-3){
				//emitter[0].onError(new NullPointerException());//报错
			}
			//emitter[0].onNext(next);//发送事件

			for(ObservableEmitter observableEmitter:emitterList){
				observableEmitter.onNext(next);
			}
		}
	}
}
