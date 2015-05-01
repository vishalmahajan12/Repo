package threading;

public class Anonymous {
	class InnerNested {

	}

	public static void main(String... strings) {
		int a = 7;
		Job j = new Job();
		Thread t = new Thread(new Job() {

			@Override
			public void run() {
				show();
			};

			void show() {
				System.out.println("a =" + a);
			}

		});
		t.start();
	}

}

class Job implements Runnable {

	@Override
	public void run() {
		System.out.println("a = 10");
	}

}
