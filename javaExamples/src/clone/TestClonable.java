package clone;

public class TestClonable {

	public static void main(String[] args) throws CloneNotSupportedException {
		Address asr = new Address("ASR");
		Integer age = 22;
		String name = "vikas";
		Person vikas = new Person(age, asr, name);

		System.out.println(asr);
		modify(asr.getCity());
		System.out.println(asr);
		Person vishal = vikas.clone();

		// vishal.setName("vishal");
		// vishal.address = new Address("DEL");
		// vishal.setAddress(new Address("AA"));
		// vishal.address.setCity("AA");
		System.out.println(vikas.address.getCity());
		System.out.println(vikas == vishal);
		System.out.println(vikas.address == vishal.address);
		System.out.println(vikas.age == vishal.age);
		System.out.println(vikas.name == vishal.name);
		System.out.println(vishal);
	}

	private static void modify(String city) {
		System.out.println(city);
		city = "DEL";
		System.out.println(city);
	}

}

class Person implements Cloneable {
	Integer age;
	Address address;
	String name;

	Person(Integer age, Address address, String name) {
		this.age = age;
		this.address = address;
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	protected Person clone() throws CloneNotSupportedException {
		Person p = (Person) super.clone();
		// p.address = address.clone();
		// p.address = new Address(p.address.getCity());
		return p;
	}

	@Override
	public String toString() {
		return age + address.getCity();
	}

}

class Address implements Cloneable {
	final private String city;

	public Address(String city) {
		this.city = city;
	}

	// public String getCity() {
	// return new String(city);
	// }

	public String getCity() {
		return city;
	}

	// @Override
	// protected Address clone() throws CloneNotSupportedException {
	// return (Address) super.clone();
	// }
	@Override
	public String toString() {
		return city;
	}
}