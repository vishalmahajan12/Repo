package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.sun.org.apache.xpath.internal.operations.Number;

import staticPackage.StaticFieldHolder;

public class TestMap {

	protected void finalize() throws Throwable {
		System.out.println("finalize");
		
		TreeMap tm = new TreeMap();
		tm.put(new TestMap(), "null");
		tm.put(new TestMap(), "null");
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

		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(1);
		list.add(5);
		list.add(3);
		
		//Collections.sort(list);
		System.out.println(list);
		System.out.println(Collections.binarySearch(list, 2));
		
		Collections.sort(list,new Comp());
		System.out.println(list);
		System.out.println(Collections.binarySearch(list, 2, new Comp()));
		
	}
	
	static class Comp implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2.compareTo(o1);
		}
		
	}
	
	static void dis(List<?> l) {
			//l.add(1);
	}

	private static void test() {
		HashKey a1 = new HashKey();
		a1.a = 5;

		HashKey a2 = new HashKey();
		a2.a = 5;

		Set<HashKey> set = new HashSet<HashKey>();
		set.add(a1);
		set.add(a2);

		//a2.a = 6;
		System.out.println("size = " + set.size());
		System.out.println(a1.equals(a2));

		for(Object aa1 : set) { 
			System.out.println(((HashKey)aa1).a);

		}

		Integer i = new Integer(100000);
		Integer i1 = new Integer(500000);

		Map<HashKey, Integer> mm = new HashMap<HashKey, Integer>();
		mm.put(a1, i);
		System.out.println(mm);
		mm.put(a2, i1);
		a2.a = 6;
		System.out.println(mm);
		System.out.println(mm.size());

	}

}
