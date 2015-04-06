package serialization;

public class BucketProblem {
	 private int bucket = 0;

	public int getBucket() {
		return bucket;
	}

	public String showBucket(){
		//System.out.println();
		return "Bucket = "+ getBucket();
	}

	public void setBucket(int bucket) {
		this.bucket = bucket;
	}

	public static void main(String[] args) {
		Tab tab1 = new Tab();
		Thread t1 = new Thread(tab1);

		Thread t2 = new Thread(tab1);

		Thread t3 = new Thread(tab1);

		t1.start();
		t2.start();
		t3.start();
	}

}

class Tab implements Runnable {

	BucketProblem bucketProblem = new BucketProblem();

	public void run() {
		for(int i=0; i < 100;i++) {
			addDrop();
		}
	}

	synchronized void addDrop() {
		int bucket = bucketProblem.getBucket() + 1;
		bucketProblem.setBucket(bucket);
		System.out.println( "Thrad name : "+Thread.currentThread().getName() + " added one drop." + bucketProblem.showBucket());
	}

}
