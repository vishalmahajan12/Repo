package threading.concurrent.excecutorFramework.copy;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import threading.concurrent.tasks.DoMultiplecation;
import threading.concurrent.tasks.DoSum;


public class TestExcecutor {

	public static void main(String[] args) throws InterruptedException {
		int[] q = { 1,2,3,4 };
		CountDownLatch countDownLatch = new CountDownLatch(6);
		
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		long nanoTime = System.nanoTime();
		executorService.submit(new DoSum<CountDownLatch>(q, countDownLatch));
		executorService.submit(new DoMultiplecation<CountDownLatch>(q, countDownLatch));
		executorService.submit(new DoSum<CountDownLatch>(q, countDownLatch));
		executorService.submit(new DoMultiplecation<CountDownLatch>(q, countDownLatch));
		executorService.submit(new DoSum<CountDownLatch>(q, countDownLatch));
		executorService.submit(new DoMultiplecation<CountDownLatch>(q, countDownLatch));
		executorService.shutdown();
		countDownLatch.await();
		System.out.println(System.nanoTime() - nanoTime);
	}
	
}
