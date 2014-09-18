package threading.concurrent.tasks;

import java.util.concurrent.Callable;

public class DoMultiplecationCallable implements Callable<Integer>{
	int[] nums;

	public DoMultiplecationCallable(int[] nums) {
		this.nums = nums;
	}

	@Override
	public Integer call() throws Exception {
		int result =1;
		System.out.println(Thread.currentThread().getName());
		for(int i=0;i< nums.length;i++){
			result*=nums[i];
			Thread.sleep(100);
		}
		return result;
	}

}
