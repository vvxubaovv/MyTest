package com.xubao.test.simpleTest.webService;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/7/27
 */
@WebService
public class RpcTest implements IRpcTest
{
	public List<Info> infos = new ArrayList<>();

	@Override
	public void hello(String name)
	{
		System.out.println("hello " + name);
	}

	@Override
	public String nihao(String name)
	{
		String nihao = "nihao " + name;
		System.out.println(nihao);
		return nihao;
	}

	@Override
	public void setInfo(Info info)
	{
		infos.add(info);
		System.out.println("info=" + info);
	}

	@Override
	public Info getInfo(String name)
	{
		Info v = null;
		for(Info i : infos)
		{
			if(i.getName().equals(name))
			{
				v = i;
			}
		}
		System.out.println("get info=" + v);
		return v;
	}
}
