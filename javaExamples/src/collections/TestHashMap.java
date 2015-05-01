package collections;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {

	public static void main(String[] args) {
		Person1 p = new Person1("sumit");
		Person1 p1 = new Person1("sumit");
		
		Map<Person1, String> map = new HashMap<Person1, String>();
		for(int i = 0 ; i <13 ; i++) {
			map.put(p, "s");

		}
		System.out.println(map.size());
		
		
		System.out.println(map.get(p1));
	}
}
class Person1
{
	private String name;

	public Person1(String name) {
		super();
		this.name = name;
	}
	
//	@Override
//	public int hashCode() {
//		Calendar calendar = Calendar.getInstance();
//		int hash = (int) ((calendar.getTimeInMillis() % 10000) * 13);
//		return 1;
//	}
//	
//
//	@Override
//	public boolean equals(Object obj) {
//		if(1 == 1)
//			return false;
//		return true;
//	}
	
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person1 other = (Person1) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public void setName(String name) {
		this.name = name;
	}
}