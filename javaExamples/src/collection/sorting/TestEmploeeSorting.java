package collection.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pojos.Employee;

public class TestEmploeeSorting {
	public static void main(String[] args) {
		Employee e1 = new Employee("name1", 35000, 20);
		Employee e2 = new Employee("name2", 15000, 25);
		Employee e3 = new Employee("name1", 35000, 30);
		Employee e4 = new Employee("name3", 50000, 35);

		List<Employee> employs = new ArrayList<Employee>();
		employs.add(e1);
		employs.add(e2);
		employs.add(e3);
		employs.add(e4);
		System.out.println(employs);
		System.out.println("After sorting");
		Collections.sort(employs, new SortEmployeeComparator());
		System.out.print(employs);
	}
}
