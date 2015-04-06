package threading.concurrent.tasks;

import java.util.concurrent.Callable;

public class DoSumCallable implements Callable<Integer>{
	int[] nums;
	public DoSumCallable(int[] n) {
		nums = n;
	}

	@Override
	public Integer call() throws Exception {
		int result = 0;
		System.out.println(Thread.currentThread().getName()+".....");
		for(int i=0;i< nums.length;i++){
			result+=nums[i];
			Thread.sleep(100);
			System.out.println("after exception");
		}
		return result;
	}

}
