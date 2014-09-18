package memory;

public class ArrayMemory {

	
	public static void main(String[] args) {
		int x1 = 10;
		int x2 = 20;
		int[] x = new int[2];
		x[0] = x1;
		x[1] = x2;
		x1=50;
		x2=30;
		System.out.println(x[0]);
		System.out.println(x[1]);
	}
}
