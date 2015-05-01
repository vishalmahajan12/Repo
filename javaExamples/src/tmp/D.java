package tmp;

import java.util.ArrayList;
import java.util.List;


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
		
		List<? super D> l = new ArrayList<C>();
		l.add(new D());
		C c = new D();
		//c.display(new B());
		
		c.display(new A());
	}
}
