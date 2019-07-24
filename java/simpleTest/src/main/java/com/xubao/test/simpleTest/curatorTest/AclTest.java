package com.xubao.test.simpleTest.curatorTest;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.ACLProvider;
import org.apache.curator.retry.RetryForever;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;

import java.util.Arrays;
import java.util.List;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/4/30
 */
public class AclTest
{
	public static void main(String[] args) throws Exception
	{
		ACLProvider aclProvider = new ACLProvider()
		{

			/*
			scheme:
				id格式为xx:yy 无效为:后的数据无效
				world 不设置权限 id:无效
				auth  创建用户 id:无效
				digest 指定用户 id:必须为密码加密后的值
			*/
			List<ACL> aclList = Arrays.asList(new ACL(ZooDefs.Perms.READ, new Id("digest", "ww:admin")), new ACL(ZooDefs.Perms.CREATE, new Id("digest", "x33b:x44b")));

			@Override
			public List<ACL> getDefaultAcl()
			{
				return aclList;
			}

			@Override
			public List<ACL> getAclForPath(String path)
			{
				return aclList;
			}
		};
		CuratorFramework client = CuratorFrameworkFactory.builder().aclProvider(aclProvider)
				.authorization("digest", "xb:xb".getBytes())
				.connectString("192.168.1.52:2181")
				.retryPolicy(new RetryForever(1000))
				.build();
		client.start();
		String path = "/aclTest/xb/13";
		String s = client.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath(path, "xb".getBytes());
		System.out.println(s);
		List<ACL> acls = client.getACL().forPath(path);
		System.out.println(acls);

		System.in.read();
	}
}
