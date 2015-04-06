package threading;

public class TreadExample{
	
	private Object lock = new Object();
	private Object lock1 = new Object();
	volatile int i;
	
	//ReentrantLock lock2 = new ReentrantLock();
	
	public void meth1(){
		synchronized (lock) {
			System.out.println("entered in meth1");
			try {
				int i=0;
				while(true){
					System.out.println("meth1 "+ i++);
					if(i == 300){
						Thread.yield();
					}
					if(i == 1000){
						break;
					}
			//		lock.wait();
				}
			}finally{
				
			}
			
			final int i = 0;
			class rajiv {
				
				void display(){
				System.out.println(i);
				}
			}
			/*catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		//	System.out.println("exit from meth1");
		}
	}

	public void meth2(){
		int i=0;
		synchronized (lock) {
			System.out.println("entered in meth2");
		//	lock1.notify();
				//Thread.yield();
				while(i==0){
					//Thread.yield();
					
				}
			
		}
		System.out.println("exit from meth2");
	}
	
	public void meth3(){
		synchronized (lock) {
			System.out.println("entered in meth3");
		/*	try {
				lock.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			try {
				int i=0;
				while(true){
					System.out.println("meth2 "+ i++);
					if(i == 500){
						Thread.yield();
					}
					if(i == 1000){
						break;
					}
			//		lock.wait();
				}
			}finally{
				
			}
		//	System.out.println("exit from meth3");
		}
	}
}
