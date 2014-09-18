package tmp;

public class A {
	A(){
		B a = new B();
	}
public void a() {
	System.out.println(getClass().getName());
}

protected void b() {
	System.out.println(getClass().getName());
}
}
