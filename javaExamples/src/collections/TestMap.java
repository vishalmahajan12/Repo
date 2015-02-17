package collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
		test();
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
