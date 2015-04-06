package org.hibernatejpa.example;


import javax.persistence.EntityManager;

public class MainClass {
	static EntityManager entityManager;
	
	public static void main(String[] args) {
		Employ employ = new Employ("abc");
		save(employ);
		Employ fromDb = readEmployBy(1l);
		System.out.println("Employ id - " + fromDb.id +" and name is " + fromDb.getName());
		EntityManagerUtil.shutdown();
	}

	private static Employ readEmployBy(Long id) {
		entityManager = createEntityManager();
		entityManager.getTransaction().begin();;
		System.out.println("reading from database......!");
		Employ emp = (Employ) entityManager.find(Employ.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();
		return emp;
	}

	private static void save(Employ employ) {
		entityManager = createEntityManager();
		entityManager.getTransaction().begin();
		System.out.println("saving ......!");
		entityManager.persist(employ);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	private static EntityManager createEntityManager() {
		return EntityManagerUtil.getEntityManagerFactory().createEntityManager();
	}
}
