package collection.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import pojos.Employee;

public class TestEmploeeSorting {
	public static void main(String[] args) {
		Employee e1 = new Employee("name1", 35000, 20, new Date("22/1/2011"));
		Employee e2 = new Employee("name2", 15000, 25, new Date("22/1/2000"));
		Employee e3 = new Employee("name1", 35000, 30, new Date("22/1/2015"));
		Employee e4 = new Employee("name3", 50000, 35, new Date("22/1/1985"));
		
		//using TreeSet
		Set<Employee> employees = new TreeSet<Employee>(new SortEmployeeComparator());
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		employees.add(e4);
		
		System.out.println("TreeSet ---- " + employees);
		

		//using ArrayList
		List<Employee> employs = new ArrayList<Employee>();
		employs.add(e1);
		employs.add(e2);
		employs.add(e3);
		employs.add(e4);
		System.out.println("ArrayList before ---- " + employs);
		Collections.sort(employs);
		System.out.println("After sorting default " + employs);
		Collections.sort(employs, new SortEmployeeComparator());
		System.out.println("After sorting by SortEmployeeComparator ---- " + employs);
	}
}
