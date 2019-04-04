//package com.xubao.test.simpleTest.aspectjTest.zj;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//
///**
// * @author xubao
// * @version 1.0
// * @since 2019/4/3
// */
//@Aspect
//public class Y
//{
//	@Pointcut("execution(* com.xubao.test.simpleTest.aspectjTest.A.a1(..))")
//	public void x1()
//	{
//	}
//
//	@Around("x1()")
//	public void around(ProceedingJoinPoint point) throws Throwable
//	{
//		System.out.println("开始");
//		point.proceed();
//		System.out.println("结束");
//	}
//}
