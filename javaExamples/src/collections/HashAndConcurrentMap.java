package collections;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class HashAndConcurrentMap {

	public static void main(String[] args) {
		test();
		//inInsertionsReturnPreviousValue();
		//test2();
	}

	private static void test2() {
		Hashtable<Integer, String> map3 = new Hashtable<Integer, String>();
		//map3.put(1 , null); //Not Allowed
		map3.put(1 , "1");

		TreeMap<Integer, String> map2 = new TreeMap<Integer, String>();
		map2.put(1, null);
		//map2.put(null , "ww"); //Not Allowed
		System.out.println(map2.put(1, "null"));
		//System.out.println(map2.put(1, "2"));
		System.out.println(map2.put(2, "2"));
		System.out.println(map2);

	}

	private static void insertionsReturnPreviousValue() {
		Map<Integer, String> map = new ConcurrentHashMap<Integer, String>();
		System.out.println(map.put(1, "null"));
		System.out.println(map.put(1, "2")); 
		System.out.println(map.put(2, "2"));
		System.out.println(map);

	}

	static void test(){
		//ConcurrentHashMap
		Map<String,String> myConMap = new ConcurrentHashMap<String,String>();
		myConMap.put("1", "1");
		myConMap.put("2", "1");
		myConMap.put("3", "1");
		myConMap.put("4", "1");
		myConMap.put("5", "1");
		myConMap.put("6", "1");
		System.out.println("ConcurrentHashMap before iterator: "+myConMap);
		Iterator<String> it = myConMap.keySet().iterator();

		while(it.hasNext()){
			String key = it.next();
			System.out.println(key);
			if(key.equals("3")) myConMap.put(key+"new", "new3");
		}
		System.out.println("ConcurrentHashMap after iterator: "+myConMap);


		//HashMap
		Map<String, String> myHashMap = new LinkedHashMap<String,String>(myConMap);
		myHashMap.remove("3new");

		System.out.println("HashMap before iterator: "+myHashMap);
		Iterator<String> it1 = myHashMap.keySet().iterator();
		while(it1.hasNext()){
			String key = it1.next();
			System.out.println(key);
			if(key.equals("6")) {
				//myHashMap.put(key+"newhash", "new4");
				myHashMap.remove("6");
				//break;
			}
		}
		System.out.println("HashMap after iterator: "+myHashMap);

	}
}
