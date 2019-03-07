package test;

import com.google.gson.Gson;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.queue.DistributedQueue;
import org.apache.curator.framework.recipes.queue.QueueBuilder;
import org.apache.curator.framework.recipes.queue.QueueConsumer;
import org.apache.curator.framework.recipes.queue.QueueSerializer;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/1/30
 */
public class MsgQueueTest
{
	public static void main(String[] args) throws InterruptedException, IOException
	{
		final Gson gson = new Gson();

		CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.1.52:2181", new ExponentialBackoffRetry(10000, 3));
		client.start();

		QueueSerializer<A> queueSerializer = new QueueSerializer<A>()
		{
			public byte[] serialize(A item)
			{
				return gson.toJson(item).getBytes();
			}

			public A deserialize(byte[] bytes)
			{
				return gson.fromJson(new String(bytes), A.class);
			}
		};


		QueueBuilder<A> builder = QueueBuilder.builder(client, new QueueConsumer<A>()
		{
			public void stateChanged(CuratorFramework client, ConnectionState newState)
			{

			}

			public void consumeMessage(A message) throws Exception
			{
				try
				{
					TimeUnit.SECONDS.sleep(5);
				}catch(InterruptedException e){
					System.out.println("忽略");
				}
				System.out.println(message);
			}
		},queueSerializer , "/queue/jj");
		builder.lockPath("/queue/lock");

		DistributedQueue<A> aDistributedQueue = builder.buildQueue();
		try
		{
			aDistributedQueue.start();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		TimeUnit.SECONDS.sleep(2);

		for(int i = 0; i < 1000; i++)
		{
			try
			{
//				byte[] serialize = ItemSerializer.serialize(new A(String.valueOf(i)),queueSerializer);
//				client.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath("/queue/jj/queue-",serialize );
				aDistributedQueue.put(new A(String.valueOf(i)));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			TimeUnit.SECONDS.sleep(1);
		}

		System.out.println("结束");
		System.in.read();
		try
		{
			aDistributedQueue.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		client.close();
	}

	public static class A
	{
		public String a;

		public A(String a)
		{
			this.a = a;
		}

		@Override
		public String toString()
		{
			return "A{" +
					"a='" + a + '\'' +
					'}';
		}
	}

	public static class ItemSerializer {
		private static final int VERSION = 0x00010001;

		private static final byte ITEM_OPCODE = 0x01;
		private static final byte EOF_OPCODE = 0x02;

		private static final int INITIAL_BUFFER_SIZE = 0x1000;

		public static <T> byte[] serialize(T item, QueueSerializer<T> serializer) throws Exception {
			ByteArrayOutputStream bytes = new ByteArrayOutputStream(INITIAL_BUFFER_SIZE);
			DataOutputStream out = new DataOutputStream(bytes);
			out.writeInt(VERSION);

			byte[] itemBytes = serializer.serialize(item);
			out.writeByte(ITEM_OPCODE);
			out.writeInt(itemBytes.length);
			if (itemBytes.length > 0) {
				out.write(itemBytes);
			}

			out.writeByte(EOF_OPCODE);
			out.close();

			return bytes.toByteArray();
		}
	}
}
