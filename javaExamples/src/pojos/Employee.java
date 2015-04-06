package pojos;

public class Employee {

	public Employee(String name, Integer salary, int age) {
		this.name = name;
		this.salary = salary;
		this.age = age;
	}

	private String name;
	private Integer salary;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return this.getName() + " - " + this.getSalary() + " - "
				+ this.getAge();
	}

}
