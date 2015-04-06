package org.hibernatejpa.example;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

	private static EntityManagerFactory buildEntityManagerFactory() {
		try {
			return Persistence.createEntityManagerFactory("org.hibernatejpa.example");

		} catch (Throwable ex) {
			System.err.println("Initial entityManagerFactory creation failed. " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getEntityManagerFactory().close();
	}
}
