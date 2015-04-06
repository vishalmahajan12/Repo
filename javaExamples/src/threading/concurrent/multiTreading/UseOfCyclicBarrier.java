package threading.concurrent.multiTreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import threading.concurrent.tasks.DoMultiplecation;
import threading.concurrent.tasks.DoSum;


public class UseOfCyclicBarrier {
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

		PrintTrip barrierAction = new PrintTrip();
		CyclicBarrier barrier = new CyclicBarrier(3,barrierAction);
		int[] q = { 1,2,3,4 };
		new DoSum<CyclicBarrier>(q,barrier);
		new DoMultiplecation<CyclicBarrier>(q,barrier);
		barrier.await();
		System.out.println("main finished..");
	}	
}

class PrintTrip implements Runnable {

	@Override
	public void run() {
	System.out.println("tripped CyclicBarrier");	
	}
	
}
