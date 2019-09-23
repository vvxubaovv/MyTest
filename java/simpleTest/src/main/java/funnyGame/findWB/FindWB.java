package funnyGame.findWB;

import com.xubao.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FindWB
{
	public static void main(String[] args)
	{
		List<Double[]> list = create(3.2, 7.3, 100, 1, 100);
//		System.out.println(list);

//		double loss = loss(7, 5, list);
//		System.out.println(loss);


		double[] wb = getWB(100000, 0, 0, list);
		System.out.println(Arrays.toString(wb));
	}


	private static double[] getWB(int count, double initW, double initB, List<Double[]> list)
	{
		double newW = initW;
		double newB = initB;
		for(int i = 0; i < count; i++)
		{
			Log.log("loss={}", loss(newW, newB, list));
			double nowW = newW;
			double nowB = newB;
			newW = newW(nowW, nowB, list);
			newB = newB(nowW, nowB, list);
		}


		return new double[]{newW, newB};
	}

	private static double rate = 0.00005;

	private static double newW(double w, double b, List<Double[]> list)
	{
		double dw = 0;
		for(Double[] xy : list)
		{
			double temp = (w * xy[0] + b) - xy[1];
			dw += 2 * temp * xy[0];
		}
		Log.log("dw={}", ((dw)) / list.size());
		return w - (rate * (dw)) / list.size();
	}

	private static double newB(double w, double b, List<Double[]> list)
	{
		double db = 0;
		for(Double[] xy : list)
		{
			double temp = (w * xy[0] + b) - xy[1];
			db += 2 * temp;
		}
		Log.log("db={}", ((db)) / list.size());
		return b - (rate * (db)) / list.size();
	}

	private static double loss(double w, double b, List<Double[]> list)
	{
		double loss = 0;
		for(Double[] xy : list)
		{
			double temp = xy[1] - (w * xy[0] + b);
			loss += Math.pow(temp, 2);
		}

		return loss / list.size();
	}

	private static List<Double[]> create(double w, double b, int count, double xStart, double xEnd)
	{
		List<Double[]> list = new ArrayList<>();

		Random random = new Random();
		for(int i = 0; i < count; i++)
		{
			double x = (random.nextInt() % (xEnd - xStart)) + xStart;

			double y = x * w + b + Math.sin(x);

			Double[] xy = new Double[2];
			xy[0] = x;
			xy[1] = y;

			list.add(xy);
		}

		return list;
	}
}
