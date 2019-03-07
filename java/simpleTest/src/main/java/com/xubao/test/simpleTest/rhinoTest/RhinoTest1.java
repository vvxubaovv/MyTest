package com.xubao.test.simpleTest.rhinoTest;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.tools.shell.Global;
import org.mozilla.javascript.tools.shell.Main;
import org.mozilla.javascript.tools.shell.ShellContextFactory;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.ByteArrayInputStream;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/10/12
 */
public class RhinoTest1
{
	public static void main(String[] args) throws ScriptException
	{
		test6();
	}

	static void test1() throws ScriptException
	{
		ScriptEngineManager factory = new ScriptEngineManager();//step1
		ScriptEngine engine = factory.getEngineByName("JavaScript");//Step2
		engine.eval("print('Hello, Scripting')");//Step3
		//engine.eval("importPackage(java.io)");//Step3

	}

	static void test2()
	{
		Context ctx = Context.enter();
		Scriptable scope = ctx.initStandardObjects();

		String jsStr = "importPackage(java.io)";
		Script script = ctx.compileString(jsStr, "<stdin>", 2, null);
//		Object result=ctx.evaluateString(scope, jsStr, null, 0,null);
		Object result = script.exec(ctx, scope);
		System.out.println("result=" + result);
	}

	static void test3()
	{
		Context ctx = Context.enter();
		Scriptable scope = new Global();//ctx.initStandardObjects();

		String jsStr = "print(1+2)";
		Script script = ctx.compileString(jsStr, null, 0, null);
//		Object result=ctx.evaluateString(scope, jsStr, null, 0,null);
		Object result = script.exec(ctx, scope);
		System.out.println("result=" + result);
	}

	static void test4()
	{
		String str = "importPackage(com.xubao.test.simpleTest.rhinoTest)\na=new A()\nprint('a='+a)\n";
		ByteArrayInputStream bais = new ByteArrayInputStream(str.getBytes());

		Main.setIn(bais);

		Main.main(new String[0]);

	}

	static void test5()
	{
		ContextFactory factory = new ShellContextFactory();
		Context ctx = factory.enterContext();

		Global scope = new Global();//ctx.initStandardObjects();
		scope.init(factory);

		String jsStr = "importPackage(java.io)";
		boolean b = ctx.stringIsCompilableUnit(jsStr);
		System.out.println("b=" + b);

		Script script = ctx.compileString(jsStr, "<stdin>", 0, null);
//		Object result=ctx.evaluateString(scope, jsStr, null, 0,null);
		Object result = script.exec(ctx, scope);
		System.out.println("result=" + result);
	}

	static void test6()
	{
		ContextFactory factory = new ShellContextFactory();
		Context ctx = factory.enterContext();

		Global scope = new Global();
		//看看
		scope.init(factory);

		exec(ctx,scope,"importPackage(com.xubao.test.simpleTest.rhinoTest)");
		exec(ctx,scope,"importPackage(com.xubao.test.simpleTest.rhinoTest)");
		exec(ctx,scope,"importPackage(com.xubao.test.simpleTest.rhinoTest)");
		exec(ctx,scope,"print('AS='+A.SA)");
		A.SA = "kkkk";
		System.out.println("Sb:"+B.SB);
		exec(ctx,scope,"print('AS='+A.SA)");
		//exec(ctx,scope,"print('SB='+B.SB)");//包可见的无法访问
		exec(ctx,scope,"A.SA='jschange'");
		System.out.println("j SA="+A.SA);
	}

	static void exec(Context ctx, Global scope, String jsStr)
	{
		boolean b = ctx.stringIsCompilableUnit(jsStr);
		if(b)
		{
			Script script = ctx.compileString(jsStr, "<stdin>", 0, null);
			Object result = script.exec(ctx, scope);
			System.out.println("result=" + result);
		}
		else
		{
			System.out.println("不可编译");
		}
	}
}
