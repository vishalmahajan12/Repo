package threading.concurrent.excecutorFramework.copy;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import threading.concurrent.tasks.DoMultiplecationCallable;
import threading.concurrent.tasks.DoSumCallable;

public class TestExcecutorWithCallableTask {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int[] q = { 1,2,3,4,5,6,7 };
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		long nanoTime = System.nanoTime();
		Future<Integer> f1 = executorService.submit(new DoSumCallable(q));
		System.out.println("f1 completed");
		Future<Integer> f2 = executorService.submit(new DoMultiplecationCallable(q));
		System.out.println("f2 completed");
		
		executorService.shutdown();
		System.out.println(f1.get());
		System.out.println(f2.get());
		System.out.println(f1.get() + f2.get());
		System.out.println(System.nanoTime() - nanoTime);
	}
}
