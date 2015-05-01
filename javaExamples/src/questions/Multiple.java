package questions;

import java.util.HashMap;
import java.util.Map;

public class Multiple {

	public static void main(String[] args) {

		Multiple multiple = new Multiple();
		multiple.testHashMap();
		System.out.println(multiple.q1());
		System.out.println(multiple.q2());

	}

	void testHashMap() {
		System.out.println("testHashMap method start/.....");
		Map<String, String> map = new HashMap<String, String>();
		String s1 = "VISHAL";
		String s2 = new String("VISHAL");
		map.put(s1, "JAVA");
		System.out.println(map.get(s2));
		
		//------------------------------

		s1 = "VISHAL";
		s2 = "vishal";
		map.put(s1, "JAVA");
		System.out.println(map.get(s2));
	}

	@SuppressWarnings("finally")
	int q1() {
		int i = 0;
		try {
			i++;
			return i;
		} catch (Exception e) {
			i = 5;
			return i;
		} finally {
			i = 10;
			return i;
		}

	}
	
	@SuppressWarnings("finally")
	int q2() {
		int i = 0;
		try {
			return i++;
		} catch (Exception e) {
			return i++;
		} finally {
			return i++;
		}
	}
}
