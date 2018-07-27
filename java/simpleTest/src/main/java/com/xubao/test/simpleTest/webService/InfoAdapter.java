package com.xubao.test.simpleTest.webService;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/7/27
 */
public class InfoAdapter extends XmlAdapter<String, Info>
{
	@Override
	public Info unmarshal(String v) throws Exception
	{
		String[] split = v.split(":");
		Info info = new Info();
		info.setName(split[0]);
		info.setAge(Integer.parseInt(split[1]));
		info.setSex(split[2]);

		String[] split1 = split[3].split(",");
		List<String> friend = null;
		for(String f : split1)
		{
			if(friend == null)
			{
				friend = new ArrayList<>();
			}
			friend.add(f);
		}
		info.setFriend(friend);
		return info;
	}

	@Override
	public String marshal(Info v) throws Exception
	{
		return v.toStr();
	}
}
