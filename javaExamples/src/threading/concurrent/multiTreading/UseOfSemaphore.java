package threading.concurrent.multiTreading;

import java.util.concurrent.Semaphore;

import threading.concurrent.tasks.DoMultiplecation;
import threading.concurrent.tasks.DoSum;


public class UseOfSemaphore {
	public static void main(String[] args) {

		Semaphore object = new Semaphore(1);
		int[] q = { 1,2,3,4};
		new DoSum<Semaphore>(q,object);
		new DoMultiplecation<Semaphore>(q,object);
	}	
}
