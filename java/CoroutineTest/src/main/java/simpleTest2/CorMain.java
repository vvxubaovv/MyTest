package simpleTest2;

import com.offbynull.coroutines.user.CoroutineRunner;

import simpleTest.MyCoroutine;

public class CorMain {
	public static void main(String[] args) {MyCoroutine mc = new MyCoroutine();
		CoroutineRunner r = new CoroutineRunner(mc);
		MyCoroutine.x++;
		System.out.println(r.execute());
		MyCoroutine.x++;
		r.execute();
		MyCoroutine.x++;
		r.execute();
		MyCoroutine.x++;
		System.out.println(r.execute());
		System.out.println("----------------------");
		
	}
}
