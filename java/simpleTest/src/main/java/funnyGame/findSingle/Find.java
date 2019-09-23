package funnyGame.findSingle;

import java.util.*;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/11/20
 */
public class Find
{
	public static void main(String[] args)
	{
//		List<Integer> list = create(20000, 3);
//		System.out.println(list);
//
//		int answer = findOne(list);
//		System.out.println("answer:" + answer);


		System.out.println("find two:" + Arrays.toString(findTwo(create(10, 0, 8545616))));
	}

	//n
	public static int findOne(List<Integer> list)
	{
		int temp = 0;
		for(Integer i : list)
		{
			temp ^= i;
		}
		return temp;
	}

	//n^2
	public static int[] findTwo(List<Integer> list)
	{
		int[] result = new int[2];
		int resultCount = 0;
		for(Integer m : list)
		{
			int count = 0;
			for(Integer n : list)
			{
				if(m.equals(n))//Integer用equals 否则超出[-128,127] 不等
				{
					count++;
				}
			}

			if(count == 1)
			{
				result[resultCount] = m;
				resultCount++;
				if(resultCount == 2)
				{
					break;
				}
			}
		}

		return result;
	}

	public static List<Integer> create(int doubleNumb, Integer... singles)
	{
		List<Integer> list = new ArrayList<>();
		Random random = new Random();

		List<Integer> singleList = Arrays.asList(singles);

		for(int i = 0; i < doubleNumb; i++)
		{
			int nextInt;
			do
			{
				nextInt = random.nextInt();
			} while(singleList.contains(nextInt));
			list.add(nextInt);
			list.add(nextInt);
		}

		list.addAll(singleList);

		Collections.shuffle(list);
		return list;
	}
}
