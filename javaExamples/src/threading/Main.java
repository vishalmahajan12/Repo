package threading;



public class Main {

	private void proMeth() {
		System.out.println("pro meth");
	}
	
	public void pubmeth() {
		Main main = new Main();
		main.proMeth();
	}
	
	public static void main(String[] args) throws Exception {
		
		
		final TreadExample f1 = new TreadExample();
		Main main = new Main();
		main.proMeth();
		
		new Thread(new Runnable() {
			public void run() {
				f1.meth1();
			}
		}).start();
	
		
		new Thread(new Runnable() {
			public void run() {
				f1.meth3();
			}
		}).start();

	/*	new Thread(new Runnable() {
			public void run() {
				f1.meth3();
			}
		}).start();*/
	}
}
