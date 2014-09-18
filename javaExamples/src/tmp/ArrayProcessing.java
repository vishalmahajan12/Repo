package tmp;

import java.util.LinkedList;
import java.util.List;


public class ArrayProcessing {
	
	final String s = "v";
	
	{
		System.out.println(s);
	}
	
	public static void main(String[] args) throws InterruptedException {
		//arraySearchTime();
		String one = new String("1");
		one = one.intern();
		String o1 = "1";
		System.out.println(one == o1);
	}

	private static void arraySearchTime() throws InterruptedException {
		String[] strArray1 = new String[1000000];
		String[] strArray2 = new String[1000000];
		for (int i = 0; i < 1000000; i++) {
			strArray1[i] = i+"";
			strArray2[i] = i+"";
		}
		
		long time = System.nanoTime();
		//for (int i = 1000000-1; i > 0; --i) {
		for (int i = 0; i < 1000000; i++) {
			String x = strArray1[i];
		}
		System.out.println("time taken - " + (System.nanoTime() - time));
		
		Thread.sleep(2000);
		time = System.nanoTime();
		for (int i = 0; i < 1000000; i++) {
			String x = strArray2[i];
		}
		System.out.println("time taken - " + (System.nanoTime() - time));
		/*Thread.sleep(2000);
		time = System.nanoTime();*/
		/*System.out.println(strArray[999995]);
		System.out.println("time taken - " + (System.nanoTime() - time));*/
	}
	
	private static void listSearchTime() throws InterruptedException {
		List<String> list = new LinkedList<String>();
		for (int i = 0; i < 1000000; i++) {
			list.add(i+"");
		}
		long time = System.nanoTime();
		System.out.println(time);
		System.out.println(list.get(5));
		System.out.println("time taken - " + (System.nanoTime() - time));
		Thread.sleep(2000);
		time = System.nanoTime();
		System.out.println(list.get(999995));
		System.out.println("time taken - " + (System.nanoTime() - time));
	}
	
}
