package collections;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import staticPackage.StaticFieldHolder;

public class TestMap {

	protected void finalize() throws Throwable {
		System.out.println("finalize");
	};
	
	 public void runMe() throws Throwable {
	        System.out.println("--- Starting runMe. Static value: "
	            + StaticFieldHolder.start);
	        StaticFieldHolder.start = StaticFieldHolder.start + 4;
	        System.out.println("--- Finishing runMe. Static value: "
	            + StaticFieldHolder.start);
	        finalize();
	    }
	public static void main(String[] args) throws Exception {
	
	Map<Integer, String> map = new ConcurrentHashMap<Integer, String>();
//	Collections.sort(map.entrySet());
//	map.put(4, null);
	System.out.println(map.put(1, "null"));
	System.out.println(map.put(1, "2"));
	System.out.println(map.put(2, "2"));
	System.out.println(map);
	
	Map<Integer, String> map2 = new TreeMap<Integer, String>();
	//map2.put(null, "null");
	System.out.println(map2.put(1, "null"));
	//System.out.println(map2.put(1, "2"));
	System.out.println(map2.put(2, "2"));
	System.out.println(map2);
	
	Set<Integer> set =new HashSet<Integer>();
	System.out.println(set.add(1));
	System.out.println(set.add(1));
	System.out.println(set);
}

}