package com.xubao.test.simpleTest.rhinoTest;

import org.mozilla.javascript.*;
import org.mozilla.javascript.tools.ToolErrorReporter;
import org.mozilla.javascript.tools.shell.Environment;
import org.mozilla.javascript.tools.shell.Global;
import org.mozilla.javascript.tools.shell.Main;
import org.mozilla.javascript.tools.shell.QuitAction;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/10/12
 */
public class RhinoTest1
{
	public static void main(String[] args) throws ScriptException
	{
		test4();
	}

	static void test1() throws ScriptException
	{
		ScriptEngineManager factory = new ScriptEngineManager();//step1
		ScriptEngine engine =factory.getEngineByName("JavaScript");//Step2
		engine.eval("print('Hello, Scripting')");//Step3
		//engine.eval("importPackage(java.io)");//Step3

	}

	static void test2(){
		Context ctx=Context.enter();
		Scriptable scope=ctx.initStandardObjects();

		String jsStr="importPackage(java.io)";
		Script script = ctx.compileString(jsStr, "<stdin>", 2, null);
//		Object result=ctx.evaluateString(scope, jsStr, null, 0,null);
		Object result = script.exec(ctx, scope);
		System.out.println("result="+result);
	}

	static void test3(){
		Context ctx=Context.enter();
		Scriptable scope=new Global();//ctx.initStandardObjects();

		String jsStr="print(1+2)";
		Script script = ctx.compileString(jsStr, null, 0, null);
//		Object result=ctx.evaluateString(scope, jsStr, null, 0,null);
		Object result = script.exec(ctx, scope);
		System.out.println("result="+result);
	}

	static void test4(){
		String str = "importPackage(com.xubao.test.simpleTest.rhinoTest)\na=new A()\nprint('a='+a)\n";
		ByteArrayInputStream bais = new ByteArrayInputStream(str.getBytes());

		Main.setIn(bais);

		Main.main(new String[0]);

	}

	static void test5(){
		ContextFactory factory = new ContextFactory();
		Parser parser = new Parser();
		Context ctx=factory.enterContext();

		Scriptable scope=new Environment();//ctx.initStandardObjects();

		String jsStr="print(1+2)";
		boolean b = ctx.stringIsCompilableUnit(jsStr);
		System.out.println("b="+b);

		Script script = ctx.compileString(jsStr, "<stdin>", 0, null);
//		Object result=ctx.evaluateString(scope, jsStr, null, 0,null);
		Object result = script.exec(ctx, scope);
		System.out.println("result="+result);
	}

	private static class IProxy implements ContextAction, QuitAction
	{
		private static final int PROCESS_FILES = 1;
		private static final int EVAL_INLINE_SCRIPT = 2;
		private static final int SYSTEM_EXIT = 3;

		private int type;
		String[] args;
		String scriptText;

		IProxy(int type)
		{
			this.type = type;
		}

		public Object run(Context cx)
		{

				evalInlineScript(cx, scriptText);
			return null;
		}

		public void quit(Context cx, int exitCode)
		{
			if (type == SYSTEM_EXIT) {
				System.exit(exitCode);
				return;
			}
			throw Kit.codeBug();
		}
	}

	static void evalInlineScript(Context cx, String scriptText) {
//		try {
//			Script script = cx.compileString(scriptText, "<command>", 1, null);
//			if (script != null) {
//				script.exec(cx, getShellScope());
//			}
//		} catch (RhinoException rex) {
//			ToolErrorReporter.reportException(
//					cx.getErrorReporter(), rex);
//			exitCode = EXITCODE_RUNTIME_ERROR;
//		} catch (VirtualMachineError ex) {
//			// Treat StackOverflow and OutOfMemory as runtime errors
//			ex.printStackTrace();
//			String msg = ToolErrorReporter.getMessage(
//					"msg.uncaughtJSException", ex.toString());
//			Context.reportError(msg);
//			exitCode = EXITCODE_RUNTIME_ERROR;
//		}
	}
}
