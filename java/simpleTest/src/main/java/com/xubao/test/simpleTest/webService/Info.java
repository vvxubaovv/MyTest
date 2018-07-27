package com.xubao.test.simpleTest.webService;

import java.util.List;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/7/27
 */
public class Info
{
	private String name;
	private int age;
	private String sex;
	private List<String> friend;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public List<String> getFriend()
	{
		return friend;
	}

	public void setFriend(List<String> friend)
	{
		this.friend = friend;
	}

	public String toStr()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.name + ":");
		stringBuilder.append(this.age + ":");
		stringBuilder.append(this.sex + ":");

		if(this.getFriend() != null)
		{
			for(String f : this.getFriend())
			{
				stringBuilder.append(f + ",");
			}

			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		}

		return stringBuilder.toString();
	}

	@Override
	public String toString()
	{
		return "Info{" +
				"name='" + name + '\'' +
				", age=" + age +
				", sex='" + sex + '\'' +
				", friend=" + friend +
				'}';
	}
}
