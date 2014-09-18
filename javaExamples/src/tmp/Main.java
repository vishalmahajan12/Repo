package tmp;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*interface I {
	defaul  void show();
}*/

class Az{int i =1;void m1(){System.out.println("Az");}}
class Bz extends Az{int i = 6;void m1(){System.out.println("Bz");}}


class Aa {
	int a;

	@Override
	public boolean equals(Object obj) {
		return a == ((Aa)obj).a;
	}

	@Override
	public int hashCode() {
		return 1;
	}
	
	@Override
	public String toString() {
		return a+"";
	}
}

public class Main {
	static String s = "-";
	void do1(Az...azs) {
		System.out.println(s+=1);
	}
	void do1(Bz...bzs) {
		System.out.println(s+=2);
	}
	void do1(Aa[] bzs) {
		System.out.println(s+=3);
	}
	void do1(Object o) {
		System.out.println(s+=4);
	}
	public static void main(String[] args) {
		Az[] a = new Az[2]; 
		Bz[] b = new Bz[2];
		Aa[] c = new Aa[2];
		
		new Main().do1(a);
		new Main().do1(b);
		new Main().do1(c);
		new Main().do1(7);
		/*Main m;
		switch ("one") {
		case "one":
			
			break;

		default:
			
			break;
		}
		
		Aa a1 = new Aa();
		a1.a = 5;
		
		Aa a2 = new Aa();
		a2.a = 5;
		
		Set<Aa> set = new HashSet<Aa>();
		set.add(a1);
		set.add(a2);
		
		//a2.a = 6;
		System.out.println("size = " + set.size());
		System.out.println(a1.equals(a2));
		
		for(Object a : set) { 
			System.out.println(((Aa)a).a);
			
		}
		
		Integer i = new Integer(100000);
		Integer i1 = new Integer(500000);
		
		Map<Aa, Integer> m = new HashMap<Aa, Integer>();
		m.put(a1, i);
		System.out.println(m.keySet());
		m.put(a2, i1);
		a1.a = 6;
		System.out.println(m.keySet());
		System.out.println(m.size());

		 //ConcurrentHashMap
        Map<String,String> myMap = new ConcurrentHashMap<String,String>();
        myMap.put("1", "1");
        myMap.put("2", "1");
        myMap.put("3", "1");
        myMap.put("4", "1");
        myMap.put("5", "1");
        myMap.put("6", "1");
        System.out.println("ConcurrentHashMap before iterator: "+myMap);
        Iterator<String> it = myMap.keySet().iterator();
 
        while(it.hasNext()){
            String key = it.next();
            if(key.equals("3")) myMap.put(key+"new", "new3");
        }
        System.out.println("ConcurrentHashMap after iterator: "+myMap);
 
        //HashMap
        myMap = new HashMap<String,String>();
        myMap.put("1", "1");
        myMap.put("2", "1");
        myMap.put("3", "1");
        myMap.put("4", "1");
        myMap.put("5", "1");
        myMap.put("6", "1");
        System.out.println("HashMap before iterator: "+myMap);
        Iterator<String> it1 = myMap.keySet().iterator();

        while(it1.hasNext()){
        	String key = it1.next();
        	if(key.equals("3"))
        	{
        		myMap.put(key+"new", "new3");
        		myMap.remove("4");
        	}
        }

        System.out.println("HashMap after iterator: "+myMap);*/
        
        
      //ConcurrentHashMap
       
		new Main();
	}
	
	
	/*Main() {
		 Map<T,String> myConMap = new ConcurrentHashMap<T,String>();
	        T key44 = new T(5,2);
			myConMap.put(key44, "1");
	        myConMap.put(new T(3,4), "1");
	        myConMap.put(new T(1,6), "1");
	       
	        System.out.println("ConcurrentHashMap before iterator: "+myConMap);
	        Iterator<T> iit = myConMap.keySet().iterator();
	 
	        while(iit.hasNext()){
	            T key = iit.next();
	            if(key.equals(key44)) 
	            	myConMap.put(key44, "new3");
	        }
	        System.out.println("ConcurrentHashMap after iterator: "+myConMap);
	}*/
	
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
