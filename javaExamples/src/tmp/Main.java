package tmp;



/*interface I {
	defaul  void show();
}*/

class Az{int i =1;void m1(){System.out.println("Az");}}
class Bz extends Az{int i = 6;void m1(){System.out.println("Bz");}}


public class Main {

	static String s = "-";
	void do1(Az...azs) {
		System.out.println(s+=1);
	}
	void do1(Bz...bzs) {
		System.out.println(s+=2);
	}
	void do1(Object o) {
		System.out.println(s+=4);
	}

	static void dis(Object o) {
		System.out.println(o);
		Integer i = new Integer(0);
		i.equals(2);
	}

	static void dis(int o) {
		System.out.println("int - " + o);
		Integer i = new Integer(0);
		i.equals(2);
	}

	public static void main(String[] args) {

		Az[] a = new Az[2]; 
		Bz[] b = new Bz[2];

		new Main().do1(a);
		new Main().do1(b);
		new Main().do1(7);

	}

	class T {
		int x;
		int y;
		T(int x, int y) {
			this.x=x;
			this.y=y;
		}
		@Override
		public int hashCode() {
			return x + y;
		}

	}
}
