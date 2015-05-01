package questions;

public class VarArg {
	
	void display(Object s) {
		System.out.println( "single arg ....");
	}
	
//	void display(double s) {
//		System.out.println( ".....single arg ....");
//	}
	
	void display(String ss,String... s) {
		System.out.println( "var arg ....");
	}
	
	public static void main(String[] args) {
		VarArg arg = new VarArg();
		arg.display("nikhil");
		arg.display(1l);
		arg.display("nikhil","vishal");
	}

}
