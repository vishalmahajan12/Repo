package threading.concurrent.multiTreading;

import java.util.concurrent.CountDownLatch;

import threading.concurrent.tasks.DoMultiplecation;
import threading.concurrent.tasks.DoSum;


public class UseOfCountdownLatch {
	public static void main(String[] args) throws InterruptedException {

		CountDownLatch latch = new CountDownLatch(2);
		int[] q = { 1,2,3,4 };
		new DoSum<CountDownLatch>(q,latch);
		new DoMultiplecation<CountDownLatch>(q,latch);
		latch.await();
		System.out.println("main finished..");
	}	
}
