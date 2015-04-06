package threading.concurrent.tasks;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class DoMultiplecation<V> implements Runnable {

	int[] nums;
	int result = 1;
	V object;

	DoMultiplecation(int[] n){
		nums = n;

		new Thread(this).start();
	}

	public DoMultiplecation(int[] n, V v){
		nums = n;
		object= v;
		//new Thread(this).start();
	}

	@Override
	public void run() {
		try {
			// acquire if Semaphore
			if(object instanceof Semaphore){
				((Semaphore)object).acquire();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
		
		System.out.println("starting tread "+ Thread.currentThread().getName());
		for(int i=0;i< nums.length;i++){
			result*=nums[i];
		}
		System.out.println(Thread.currentThread().getName()+" result "+result);
		System.out.println("Done"+ Thread.currentThread().getName());

		
		
		// release if Semaphore
		if(object instanceof Semaphore){
			((Semaphore)object).release();
		}

		// call await methed if object is of CyclicBarrier
		if(object instanceof CyclicBarrier){
			try {
				((CyclicBarrier)object).await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}

		// call countDownLatch methed if object is of CountDownLatch
		if(object instanceof CountDownLatch)
			((CountDownLatch)object).countDown();

	}
}