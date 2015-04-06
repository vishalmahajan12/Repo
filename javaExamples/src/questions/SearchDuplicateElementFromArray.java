package questions;

import java.util.HashMap;
import java.util.Map;


public class SearchDuplicateElementFromArray {
	int result = -1;

	public static void main(String[] args) {
		SearchDuplicateElementFromArray s = new SearchDuplicateElementFromArray();
		int[] array = { 4, 2, 2, 5, 8, 2, 5, 7, 8, 5, 2 };
		long start = System.nanoTime();
		s.searchSubArray(array);
		long total = System.nanoTime() - start;
		System.out.println(total);
	}

	public void searchSubArray(int[] array) {
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < array.length; i++) {
			Integer t = hashMap.put(array[i], 0);
			if(t != null){
				hashMap.put(array[i], ++t);
			}
		}
		for(Integer i : hashMap.keySet())
		{
			if(hashMap.get(i) != 0) {

				System.out.println(i + "-" + hashMap.get(i));
			}
		}
	}
}