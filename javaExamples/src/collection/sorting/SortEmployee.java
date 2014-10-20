package collection.sorting;

import java.util.Comparator;

import pojos.Employee;

public class SortEmployee implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		int result = o1.getName().compareTo(o2.getName());
		if (result != 0) {
			return result;
		} else {
			return o1.getSalary().compareTo(o2.getSalary());
		}
	}
}
