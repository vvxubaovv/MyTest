package funnyGame.findCycle;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/5/11
 */
public class FindCycle
{
	public static void main(String[] args)
	{
		int size = 51;
		MyLinkedNode node = create(size, true, 19);
		find1(node);
		find2(size, node);

		find3(node);
	}

	private static void find1(MyLinkedNode head)
	{
		Set<MyLinkedNode> myLinkedNodeSet = new HashSet<>();

		MyLinkedNode now = head;
		myLinkedNodeSet.add(now);
		boolean hasCycle = false;
		while(now.after != null)
		{
			boolean add = myLinkedNodeSet.add(now.after);
			if(!add)
			{
				hasCycle = true;
				break;
			}
			now = now.after;
		}
		if(hasCycle)
		{
			System.out.println("有循环 循环开始元素:" + now + " 元素个数:" + myLinkedNodeSet.size());
		}
		else
		{
			System.out.println("没有循环 元素个数:" + myLinkedNodeSet.size());
		}
	}

	//知道size
	private static void find2(int size, MyLinkedNode head)
	{
		int count = 0;
		MyLinkedNode now = head;
		boolean hasCycle = false;
		while(now.after != null)
		{
			count++;
			if(count > size)
			{
				hasCycle = true;
				break;
			}
			now = now.after;
		}

		if(hasCycle)
		{
			System.out.println("有循环 循环开始元素:" + now);
		}
		else
		{
			System.out.println("没有循环");
		}
	}

	private static void find3(MyLinkedNode head)
	{
		MyLinkedNode step1 = head;
		MyLinkedNode step2 = head;

		boolean hasCycle = false;
		while(true)
		{
			System.out.println("step1:"+step1);
			System.out.println("step2:"+step2);
			step1 = step1.after;
			if(step1 == null)
			{
				hasCycle = false;
				break;
			}
			try
			{
				step2 = step2.after.after;
			}
			catch(NullPointerException e)
			{
				hasCycle = false;
				break;
			}

			if(step1 == step2)
			{
				System.out.println("step1:"+step1);
				System.out.println("step2:"+step2);
				hasCycle = true;
				break;
			}

		}

		if(hasCycle)
		{
			System.out.println("有循环");
		}
		else
		{
			System.out.println("没有循环");
		}
	}

	static class MyLinkedNode
	{
		public MyLinkedNode before;
		public MyLinkedNode after;
		public Object data;

		public MyLinkedNode(MyLinkedNode before, MyLinkedNode after, Object data)
		{
			this.before = before;
			this.after = after;
			this.data = data;
		}

		@Override
		public String toString()
		{
			return "MyLinkedNode{" +
//					"before=" + before +
//					", after=" + after +
					", data=" + data +
					'}';
		}
	}

	private static MyLinkedNode create(int count, boolean cycle, int cycleStartIndex)
	{
		MyLinkedNode head = null;
		MyLinkedNode now = null;
		MyLinkedNode cycleStart = null;
		for(int i = 0; i < count; i++)
		{
			MyLinkedNode node = new MyLinkedNode(null, null, i);
			if(now == null)
			{
				now = node;
				head = node;
			}
			else
			{
				now.after = node;
				node.before = now;
				now = node;
			}

			if(cycle && i == cycleStartIndex)
			{
				cycleStart = node;
			}
		}

		now.after = cycleStart;

		return head;
	}
}
