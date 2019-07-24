package com.xubao.test.simpleTest.zookeeperTest.simple;

import com.xubao.Log;
import org.apache.curator.utils.DefaultZookeeperFactory;
import org.apache.curator.utils.ZookeeperFactory;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) throws Exception {

        //在创建节点时声明为'digest' 可以理解为直接写入用户名密码  因为验证时会对密码进行处理 所以直接写入需要对密码进行 sha1然后base64处理
        //............'auth'   可以理解为用已经注册过的用户 的用户名和密码写入
        //............'world'  默认权限,所有人都可以访问,'id'指定为'anyone'

        //在添加auto时声明为digest 使用明文 代表为本次连接注册用户

//        digest2();
//        auth();
//        world();
//        world1();
        ip();
        System.in.read();
    }

    private static void ip() throws Exception {
        ZookeeperFactory zookeeperFactory = new DefaultZookeeperFactory();
        ZooKeeper zooKeeper = zookeeperFactory.newZooKeeper("192.168.1.52:2181", 50 * 1000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                Log.log("event:{}", event);
            }
        }, false);

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (zooKeeper.getState().isAlive())
                        zooKeeper.close();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }));

        String path = "/zooTest_ip_3";
        Stat stat = zooKeeper.exists(path, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                Log.log("exists event:{}", event);
            }
        });
        Log.log("stat:{}", stat);
        if (stat == null) {
            String s = zooKeeper.create(path,
                    "zooTest".getBytes(),
                    Arrays.asList(new ACL(ZooDefs.Perms.ALL,
                            new Id("ip", "192.168.1.52"))),//生成密码将整个表达式填入 echo -n admin:admin | openssl dgst -binary -sha1 | openssl base64
                    CreateMode.PERSISTENT);
            Log.log("s:{}", s);
        }

//        zooKeeper.addAuthInfo("digest", "admin:admin".getBytes());

        byte[] data = zooKeeper.getData(path, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                Log.log("get event:{}", event);
            }
        }, null);

        Log.log("data:{}", data);

        zooKeeper.close();
    }

    private static void world() throws Exception {
        ZookeeperFactory zookeeperFactory = new DefaultZookeeperFactory();
        ZooKeeper zooKeeper = zookeeperFactory.newZooKeeper("localhost:2181", 50 * 1000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                Log.log("event:{}", event);
            }
        }, false);

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (zooKeeper.getState().isAlive())
                        zooKeeper.close();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }));

        String path = "/zooTest_world_1";
        Stat stat = zooKeeper.exists(path, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                Log.log("exists event:{}", event);
            }
        });
        Log.log("stat:{}", stat);
        if (stat == null) {
            String s = zooKeeper.create(path,
                    "zooTest".getBytes(),
                    Arrays.asList(new ACL(ZooDefs.Perms.ALL,
                            new Id("world", "anyone"))),
                    CreateMode.PERSISTENT);
            Log.log("s:{}", s);
        }

        //不需要设置权限
//        zooKeeper.addAuthInfo("digest", "admin:admin".getBytes());

        byte[] data = zooKeeper.getData(path, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                Log.log("get event:{}", event);
            }
        }, null);

        Log.log("data:{}", data);

        zooKeeper.close();
    }

    private static void world1() throws Exception {
        ZookeeperFactory zookeeperFactory = new DefaultZookeeperFactory();
        ZooKeeper zooKeeper = zookeeperFactory.newZooKeeper("localhost:2181", 50 * 1000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                Log.log("event:{}", event);
            }
        }, false);

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (zooKeeper.getState().isAlive())
                        zooKeeper.close();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }));

        String path = "/zooTest_world1_1";
        Stat stat = zooKeeper.exists(path, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                Log.log("exists event:{}", event);
            }
        });
        Log.log("stat:{}", stat);
        if (stat == null) {
            String s = zooKeeper.create(path,
                    "zooTest".getBytes(),
                    null,
                    CreateMode.PERSISTENT);
            Log.log("s:{}", s);
        }

        //不需要设置权限
//        zooKeeper.addAuthInfo("digest", "admin:admin".getBytes());

        byte[] data = zooKeeper.getData(path, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                Log.log("get event:{}", event);
            }
        }, null);

        Log.log("data:{}", data);

        zooKeeper.close();
    }

    private static void auth() throws Exception {
        ZookeeperFactory zookeeperFactory = new DefaultZookeeperFactory();
        ZooKeeper zooKeeper = zookeeperFactory.newZooKeeper("localhost:2181", 50 * 1000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                Log.log("event:{}", event);
            }
        }, false);

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (zooKeeper.getState().isAlive())
                        zooKeeper.close();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }));

        zooKeeper.addAuthInfo("digest", "auth1:auth2".getBytes());//先添加authInfo

        String path = "/zooTest_auth_1";
        Stat stat = zooKeeper.exists(path, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                Log.log("exists event:{}", event);
            }
        });

        Log.log("stat:{}", stat);
        if (stat == null) {
            String s = zooKeeper.create(path,
                    "zooTest".getBytes(),
                    Arrays.asList(new ACL(ZooDefs.Perms.ALL,
                            new Id("auth", "auth1"))),//auth只需要指定用户名 后面可以代':',也可以不带
                    CreateMode.PERSISTENT);
            Log.log("s:{}", s);
        }



        byte[] data = zooKeeper.getData(path, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                Log.log("get event:{}", event);
            }
        }, null);

        Log.log("data:{}", data);

        zooKeeper.close();
    }

    private static void digest() throws Exception {
        ZookeeperFactory zookeeperFactory = new DefaultZookeeperFactory();
        ZooKeeper zooKeeper = zookeeperFactory.newZooKeeper("localhost:2181", 50 * 1000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                Log.log("event:{}", event);
            }
        }, false);

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (zooKeeper.getState().isAlive())
                        zooKeeper.close();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }));

        String path = "/zooTest11";
        Stat stat = zooKeeper.exists(path, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                Log.log("exists event:{}", event);
            }
        });
        Log.log("stat:{}", stat);
        if (stat == null) {
            String s = zooKeeper.create(path,
                    "zooTest".getBytes(),
                    Arrays.asList(new ACL(ZooDefs.Perms.ALL,
                            new Id("digest", "admin:x1nq8J5GOJVPY6zgzhtTtA9izLc="))),//生成密码将整个表达式填入 echo -n admin:admin | openssl dgst -binary -sha1 | openssl base64
                    CreateMode.PERSISTENT);
            Log.log("s:{}", s);
        }

        zooKeeper.addAuthInfo("digest", "admin:admin".getBytes());

        byte[] data = zooKeeper.getData(path, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                Log.log("get event:{}", event);
            }
        }, null);

        Log.log("data:{}", data);

        zooKeeper.close();
    }

    private static void digest2() throws Exception {
        ZookeeperFactory zookeeperFactory = new DefaultZookeeperFactory();
        ZooKeeper zooKeeper = zookeeperFactory.newZooKeeper("localhost:2181", 50 * 1000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                Log.log("event:{}", event);
            }
        }, false);

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (zooKeeper.getState().isAlive())
                        zooKeeper.close();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }));

        String path = "/zooTest_digest2_1";
        Stat stat = zooKeeper.exists(path, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                Log.log("exists event:{}", event);
            }
        });
        Log.log("stat:{}", stat);
        if (stat == null) {
            String s = zooKeeper.create(path,
                    "zooTest".getBytes(),
                    Arrays.asList(new ACL(ZooDefs.Perms.ALL,
                            new Id("digest", ZooUtil.generateDigest("admin:admin")))),
                    CreateMode.PERSISTENT);
            Log.log("s:{}", s);
        }

        zooKeeper.addAuthInfo("digest", "admin:admin".getBytes());

        byte[] data = zooKeeper.getData(path, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                Log.log("get event:{}", event);
            }
        }, null);

        Log.log("data:{}", data);

        zooKeeper.close();
    }
}
