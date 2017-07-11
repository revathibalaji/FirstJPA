package com.vam.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.vam.entity.Emp;

public class FirstLevelCaheDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("myjpa");
		EntityManager em = emf.createEntityManager();
		 
		Emp emp = em.find(Emp.class, 1001);
		System.out.println(emp);
		emp = em.find(Emp.class, 1001);
		System.out.println(emp);
		
		em.close();
		
		
	}

}
