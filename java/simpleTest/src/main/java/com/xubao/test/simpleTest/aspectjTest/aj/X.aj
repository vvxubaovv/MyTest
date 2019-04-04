package com.xubao.test.simpleTest.aspectjTest.aj;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/4/3
 */
public aspect X
{
	//不能增强main方法......
	void around():call(* com.xubao.test.simpleTest.aspectjTest.A.a1(..)){
		System.out.println("开始事务...");
		proceed();
		System.out.println("事务结束...");
	}

	after():call(* java.awt.Point.getX(..)){
		System.out.println("after getX");
	}
}
