package tmp;


public class D extends C {
	public void display(A a){
		System.out.println("sub D");
	}
	
	/*public int display(B b){
		System.out.println("sub D");
		return 0;
	}
	*/
	public static void main(String[] args) {
		
		C c = new D();
		//c.display(new B());
		
		c.display(new A());
	}
}
