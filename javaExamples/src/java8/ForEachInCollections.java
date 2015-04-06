package java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ForEachInCollections {
	public static void main(String[] args) {
		test();
	}

	private static void test() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("1", "one");
		map.put("12", "one2");
		map.put("123", "one23");
//		map.entrySet().forEach(new Consumer<Map.Entry<String, String>>() {
//
//			@Override
//			public void accept(Map.Entry<String, String> t) {
//				System.out.println(t);
//
//			}
//		});
		// previous call is equals to the next single line code
		
		map.entrySet().forEach(e -> System.out.println(e));
		
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(2);
		list.add(3);
		list.forEach((l) -> System.out.println(l));
	}
}
