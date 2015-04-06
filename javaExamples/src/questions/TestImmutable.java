package questions;

import java.io.IOException;

public  class TestImmutable  {

	public static void main(String[] args) throws IOException {
		XX x = new XX();
		x.x = 10;
		Immutable m = new Immutable(5, x);
		System.out.println(m.getX().x);
		/*x.x = 20;
		System.out.println(m.x.x);*/ // If not private
		m.getX().x=30;
		System.out.println(m.getX().x);
	}

}

final class Immutable {
	final private int i;
	final private XX x;
	public Immutable(int i, XX x) {
		this.i = i;
		this.x = x;
	}
	public int getI() {
		return i;
	}
	public XX getX() {
		XX local = new XX();
		local.x = x.x;
		return local;
	}
}

class XX {
	XX(){}
	int x;
	void aa() throws IOException{

	}
}

class YY extends XX {
	YY(){}
	void aa(){
	}
}