package collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestLinkedHashMap {

	public static void main(String[] args) {
		Map<String,String> list = new LinkedHashMap<String,String>();
		list.put("b", "b");
		list.put("a", "a");
		list.put("c", "c");
		list.put("d", "d");
		
		for(String s: list.keySet()) {
			System.out.println(list.get(s));
		}
		
	}
	
}
