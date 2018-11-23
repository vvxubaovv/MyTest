package funnyGame.findSingle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/11/20
 */
public class Find
{
	public static void main(String[] args)
	{
		List<Integer> list = create(20000, 3);
		System.out.println(list);

		int answer = find(list);
		System.out.println("answer:" + answer);
	}

	public static int find(List<Integer> list)
	{
		int temp = 0;
		for(Integer i : list)
		{
			temp ^= i;
		}
		return temp;
	}

	public static List<Integer> create(int doubleNumb, int single)
	{
		List<Integer> list = new ArrayList<>();
		Random random = new Random();

		for(int i = 0; i < doubleNumb; i++)
		{
			int nextInt;
			do
			{
				nextInt = random.nextInt();
			} while(nextInt == single);
			list.add(nextInt);
			list.add(nextInt);
		}

		list.add(single);

		Collections.shuffle(list);
		return list;
	}
}
