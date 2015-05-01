package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestIterator {
	public static void main(String[] args) {
		
		List<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		int cursor  =1;
		Iterator<Integer> itr = arrayList.iterator();
		
		while(itr.hasNext()) {
			System.out.println("cursor size " +cursor);
			cursor++;
			int i = itr.next();
			System.out.println(i);
			if(i == 4) {
				arrayList.remove(3);
			}
			System.out.println("size is "+arrayList.size());
		}
		System.out.println(arrayList);
		
		
	}

}
