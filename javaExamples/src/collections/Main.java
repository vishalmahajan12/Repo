package collections;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

class Person implements Comparable {
	String fName;
	String lName;
	int age;
	@Override
	public int compareTo(Object o) {
		Person p=(Person)o;
		return p.lName.compareTo(this.lName);
	}
	
	@Override
	public String toString() {
			return fName;
	}
		
}

class SortPersonByFName implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		return o1.fName.compareTo(o2.fName);
	}
	
}

public class Main {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, SecurityException, InvocationTargetException, NoSuchMethodException {
		
		Person p1 = new Person();
		Person p2 = new Person();
		p1.fName="kamal";
		p1.lName="lp1";
		p1.age=10;
		
		p2.fName="shruti";
		p2.lName="lp2";
		p2.age=20;
		
		List l = new ArrayList();
		l.add(p1);
		l.add(p2);
		Collections.sort(l, new SortPersonByFName());
		System.out.println(l);
		
		
		
		CustomClassLoader loader1 =
	            new CustomClassLoader(Main.class.getClassLoader());
	        Class<?> clazz1 = loader1.loadClass("collections.TestMap");
	        Object instance1 = clazz1.newInstance();
	        clazz1.getMethod("runMe").invoke(instance1);

	        // Using the second ClassLoader
	        CustomClassLoader loader2 =
	            new CustomClassLoader(Main.class.getClassLoader());
	        Class<?> clazz2 = loader2.loadClass("collections.TestMap");
	        Object instance2 = clazz2.newInstance();
	        clazz2.getMethod("runMe").invoke(instance2);
		
		
	/*	//CustomClassLoaderParent classLoaderParent = new CustomClassLoaderParent();
		CustomClassLoader classLoaderParent = new CustomClassLoader();
		Class class1 = classLoaderParent.loadClass("collections.TestHashMap");
		Object o = (Object)class1.newInstance();
		class1.getMethod("runMe").invoke(o);
		//TestHashMap t = (TestHashMap)o;
		
		CustomClassLoader classLoader = new CustomClassLoader();
		Class class2 = classLoader.loadClass("collections.TestHashMap");
		Object o1 = (Object)class2.newInstance();
		class2.getMethod("runMe").invoke(o1);*/
		/*TestHashMap t2 = new TestHashMap();
		t2.main(null);*/
	//	t.main(null);
		testHashtable();
		List<String> str = new ArrayList<String>();
		str.add("1");
		testExtendsWithWildCard(new ArrayList<Animal>());
		List a = new ArrayList();
		a.add(new Dog());
		a.add(new Cat());
		testSuperWithWildCard(a);
	}
	
	public static void testHashtable() {
		Map<Integer, String> hashtable = new Hashtable<Integer, String>();
		hashtable.put(1, "q");
		//	hashtable.put(2, null);
		System.out.println(hashtable);
	}
	
	public static void testExtendsWithWildCard(List<? extends Animal> ob) {	//doesn't allow addition
	//	ob.add(null);			// but allow to add null
		System.out.println(ob);
	}

	public static void testSuperWithWildCard(List<? super Cat> a) {	// allow addition
	//	a.add(new Cat());
		System.out.println(a);
		//a.add(new Dog());
	}
	
}
class Animal{}
class Dog extends Animal{}
class Cat extends Animal{}