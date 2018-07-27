package com.xubao.test.simpleTest.webService;

import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/7/27
 */
@WebService
public interface IRpcTest
{
	void hello(String name);

	String nihao(String name);

	void setInfo(@XmlJavaTypeAdapter(InfoAdapter.class) Info info);

	@XmlJavaTypeAdapter(InfoAdapter.class)
	Info getInfo(String name);
}
