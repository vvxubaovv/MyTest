package com.xubao.test.simpleTest.protobufTest;

import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.InvalidProtocolBufferException;
import com.xubao.Log;

public class ExtendTest
{
	public static void main(String[] args) throws InvalidProtocolBufferException
	{
//		simple();

		ExtensionRegistry registry = ExtensionRegistry.newInstance();
		registry.add(ForExtendTest.B.b1);
		registry.add(ForExtendTest.C.c1);
//		registry.add(ForExtendTest.E.e1);

		parseATest(true, 10000_000, registry);
		parseATest(false, 10000_000, registry);
	}

	private static void simple() throws InvalidProtocolBufferException
	{
		ForExtendTest.B.Builder b = ForExtendTest.B.newBuilder();
		b.setB(20);

		ForExtendTest.C.Builder c = ForExtendTest.C.newBuilder();
		c.setC(21);

		ForExtendTest.A.Builder a = ForExtendTest.A.newBuilder();
		a.setExtension(ForExtendTest.B.b1, b.build());
		a.setExtension(ForExtendTest.C.c1, c.build());
		ForExtendTest.A aa = a.build();

		byte[] bytes = aa.toByteArray();


		ExtensionRegistry registry = ExtensionRegistry.newInstance();
		registry.add(ForExtendTest.B.b1);
		registry.add(ForExtendTest.C.c1);

		ForExtendTest.A a1 = ForExtendTest.A.parseFrom(bytes, registry);

		ForExtendTest.B b1 = a1.getExtension(ForExtendTest.B.b1);
		Log.log("b1.b={}", b1.getB());

		ForExtendTest.C c1 = a1.getExtension(ForExtendTest.C.c1);
		Log.log("c1.c={}", c1.getC());


		// D--
		ForExtendTest.D.Builder d = ForExtendTest.D.newBuilder();
		d.setD(33);
		ForExtendTest.E.Builder e = ForExtendTest.E.newBuilder();
		e.setE(44);
		d.setExtension(ForExtendTest.E.e1, e.build());

		byte[] dArr = d.build().toByteArray();

		registry.add(ForExtendTest.E.e1);
		ForExtendTest.D d1 = ForExtendTest.D.parseFrom(dArr, registry);

		Log.log("d1.d={}", d1.getD());
		Log.log("e.e1={}", d1.getExtension(ForExtendTest.E.e1));
	}

	private static void parseATest(boolean useReg, int count, ExtensionRegistry registry) throws InvalidProtocolBufferException
	{
		ForExtendTest.B.Builder b = ForExtendTest.B.newBuilder();
		b.setB(20);

		ForExtendTest.C.Builder c = ForExtendTest.C.newBuilder();
		c.setC(21);

		ForExtendTest.A.Builder a = ForExtendTest.A.newBuilder();
		a.setExtension(ForExtendTest.B.b1, b.build());
		a.setExtension(ForExtendTest.C.c1, c.build());
		ForExtendTest.A aa = a.build();

		byte[] bytes = aa.toByteArray();

		long start = System.currentTimeMillis();
		for(int i = 0; i < count; i++)
		{
			if(useReg)
			{
				ForExtendTest.A a1 = ForExtendTest.A.parseFrom(bytes, registry);
			}
			else
			{
				ForExtendTest.A a1 = ForExtendTest.A.parseFrom(bytes);
			}

		}

		long end = System.currentTimeMillis();
		Log.log("spend time:{}", end - start);
	}
}
