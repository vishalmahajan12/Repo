package serialization;

import java.io.Serializable;

public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	public Person() {
		System.out.println("Person Constructor");
	}

	public String name;
	public int age;
	public String add;
}
