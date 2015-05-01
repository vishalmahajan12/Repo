//TODO
// Not completed yet

package threading;

import serialization.Person;

public class TestThreadLocal {

	public static void main(String[] args) {
		Person p = new Person();
		p.name = "mmmm";
		
		PrintName pn = new PrintName(p);
		
		Thread t1 = new Thread(pn);
		Thread t2 = new Thread(pn);
		t1.start();
		t2.start();
		
	}
}

class PrintName implements Runnable {

	Person p;
	ThreadLocal<Person> tl = new ThreadLocal<Person>();
	boolean b = true;
	
	public PrintName(Person p) {
		this.p = p;
	}
	
	@Override
	public void run() {
		tl.set(p);
		if(b){
			tl.get().name = "asas";
			b =false;
		}
		else
			tl.get().name = "zzz";
		System.out.println(tl.get().name);
		
	}
	
	
}