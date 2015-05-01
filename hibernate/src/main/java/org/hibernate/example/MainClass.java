package org.hibernate.example;


import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

public class MainClass {
	static Session session;
	
	public static void main(String[] args) {
		
		String[] s = "asasUU-asdUcf".split("U+");
		for(String s1 : s){
			System.out.println(s1);
		}
		
		
		/*Employ superior = prepareSuperior();
		save(superior);
				
//		Thread t = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				Session session = openSession();
//				session.getTransaction().begin();
//				System.out.println("thread 2");
//				Employ emp = (Employ) session.get(Employ.class, 2l);
//				emp.setName("avc2");
//				session.update(emp);
//				session.getTransaction().commit();
//				session.close();
//				
//			}
//		});
//		t.start();
		
		Employ fromDb = readEmployBy(2l);
		System.out.println("Employ id - " + fromDb.id +" and name is " + fromDb.getName());
		HibernateUtil.shutdown();*/
	}

	private static Employ prepareSuperior() {
		Employ superior = new Employ("abc");
		Employ subordinate = new Employ("subordinate");
		subordinate.setSuperior(superior);
		subordinate.setPrimaryAdd(populateAddress("JAL:",2,subordinate));
		
		Set<Employ> setEmp = new HashSet<Employ>();
		setEmp.add(subordinate);
		
		Employ subordinate2 = new Employ("subordinate2");
		subordinate2.setSuperior(superior);
		subordinate2.setPrimaryAdd(populateAddress("DEL",3,subordinate2));
		setEmp.add(subordinate2);
				
		superior.setSubEmployees(setEmp);
		superior.setSuperior(subordinate2);
		superior.setPrimaryAdd(populateAddress("ASR",1,superior));
		return superior;
	}

	private static Address populateAddress(String a, int i, Employ employ) {
		Address address = new Address();
		address.setCity(a);
		address.setPinCode(i);
//		address.setEmploy(employ);
		return address;
	}

	private static Employ readEmployBy(Long id) {
		session = openSession();
		session.beginTransaction();
		Employ emp = (Employ) session.get(Employ.class, id);
		
		session.getTransaction().commit();
		session.close();
		

		emp.setName("zzzz");
		session = openSession();
		session.beginTransaction();
		//emp.getSubEmployees();
		Employ empz = (Employ) session.get(Employ.class, id);
		System.out.println("updating.........");
		session.update(emp);
		Employ emp2 = (Employ) session.get(Employ.class, id);
		session.getTransaction().commit();
		session.close();
		return emp;
	}

	private static void save(Employ employ) {
		session = openSession();
		session.getTransaction().begin();
		System.out.println("saving ......!");
		session.persist(employ);
		session.getTransaction().commit();
		session.close();
	}

	private static org.hibernate.classic.Session openSession() {
		return HibernateUtil.getSessionFactory().openSession();
	}
	
}
