//package com.xubao;
//
//import sun.reflect.CallerSensitive;
//import sun.reflect.Reflection;#java11被删掉了
//
///**
// * @author xubao
// * @version 1.0
// * @since 2019/5/16
// */
////将此java文件打包成jar 放入jdk 的jre 或jre 的ext中 使之被sun.misc.Launcher$ExtClassLoader加载,然后@CallerSensitive生效,否则@CallerSensitive不生效
////调用printX()报错
//public class ForReflectionTest
//{
//	@CallerSensitive
//	public void printX()
//	{
//		System.out.println("X  :" + Reflection.getCallerClass());
//	}
//}
