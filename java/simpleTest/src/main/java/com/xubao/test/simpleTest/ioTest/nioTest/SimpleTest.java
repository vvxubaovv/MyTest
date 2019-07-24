package com.xubao.test.simpleTest.ioTest.nioTest;

import com.xubao.Log;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SimpleTest
{
	//nio 即 new io 应用选择器
	public static void main(String[] args) throws IOException, InterruptedException
	{
		Thread serverThread = new Thread(new Server());
		serverThread.setDaemon(true);
		Thread clientThread = new Thread(new Client());
		serverThread.setDaemon(true);

		serverThread.start();
		TimeUnit.SECONDS.sleep(1);
		clientThread.start();

		System.in.read();
	}

	private static String ip = "192.168.1.52";
	private static int port = 12445;

	private static class Server implements Runnable
	{
		ServerSocket serverSocket;
		Selector serverSelector;
		Selector connSelector;

		private Server() throws IOException
		{
			ServerSocketChannel channel = ServerSocketChannel.open();
			channel.configureBlocking(false);
			channel.bind(new InetSocketAddress(port));
			serverSelector = Selector.open();//SelectorProvider.provider().openSelector();
			connSelector = Selector.open();
			channel.register(serverSelector, SelectionKey.OP_ACCEPT);
		}

		@Override
		public void run()
		{
			try
			{
				while(true)
				{
					int s_numb = serverSelector.selectNow();
					Log.log("server numb:{}", s_numb);


					Set<SelectionKey> keys = serverSelector.selectedKeys();
					Iterator<SelectionKey> iterator = keys.iterator();
					while(iterator.hasNext())
					{
						SelectionKey next = iterator.next();

						if(next.isAcceptable())
						{
							Log.log("server acceptable");
							ServerSocketChannel channel = (ServerSocketChannel)next.channel();
							SocketChannel acceptChannel = channel.accept();
							acceptChannel.configureBlocking(false);
							acceptChannel.register(connSelector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);

							ByteBuffer buf = createByteBuffer("accept success", 30);

							buf.flip();
							acceptChannel.write(buf);
						}
						iterator.remove();
					}

					int conn_numb = connSelector.selectNow();
					Log.log("conn numb:{}", conn_numb);

					Set<SelectionKey> connKeys = connSelector.selectedKeys();
					Iterator<SelectionKey> connIter = connKeys.iterator();
					while(connIter.hasNext())
					{
						SelectionKey next = connIter.next();
						if(next.isReadable())
						{
							Log.log("server readable");
							SocketChannel channel = (SocketChannel)next.channel();
							ByteBuffer buf = ByteBuffer.allocate(1024);
							int read = channel.read(buf);
							Log.log("server read:{}", new String(buf.array(), 0, read));

							ByteBuffer r_buf = createByteBuffer("server response", 20);

							r_buf.flip();
							channel.write(r_buf);
						}
						if(next.isWritable())
						{
							Log.log("server writable");
						}

						connIter.remove();
					}

					TimeUnit.SECONDS.sleep(2);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	private static class Client implements Runnable
	{

		Selector selector = Selector.open();
		SocketChannel channel;

		public Client() throws IOException
		{
			channel = SocketChannel.open();
			channel.configureBlocking(false);
			channel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE | SelectionKey.OP_CONNECT);
			channel.connect(new InetSocketAddress(ip, port));
		}

		@Override
		public void run()
		{
			try
			{
				while(true)
				{
					int select = selector.select();
					Log.log("client numb:{}", select);
					if(select <= 0)
					{
						continue;
					}

					Set<SelectionKey> keys = selector.selectedKeys();
					Iterator<SelectionKey> iterator = keys.iterator();
					while(iterator.hasNext())
					{
						SelectionKey next = iterator.next();

						if(next.isConnectable())
						{
							Log.log("client connectable");
							SocketChannel channel = (SocketChannel)next.channel();
							channel.finishConnect();
							ByteBuffer buf = createByteBuffer("connect hello", 40);

							buf.flip();
							channel.write(buf);
						}
						else if(next.isReadable())
						{
							Log.log("client readable");
							SocketChannel channel = (SocketChannel)next.channel();
							ByteBuffer buf = ByteBuffer.allocate(1024);
							int read = channel.read(buf);

							Log.log("client read:{}", new String(buf.array(), 0, read));

							buf.flip();
							channel.write(buf);
						}

						iterator.remove();
						TimeUnit.SECONDS.sleep(1);
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	private static ByteBuffer createByteBuffer(String content, int size)
	{
		ByteBuffer buf = ByteBuffer.allocate(size);
		if(content != null)
		{
			buf.put(content.getBytes());
		}
		return buf;
	}
}
