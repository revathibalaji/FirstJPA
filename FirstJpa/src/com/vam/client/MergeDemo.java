package com.vam.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.vam.entity.Emp;

public class MergeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("myjpa");
		EntityManager em = emf.createEntityManager();
		Emp emp = em.find(Emp.class, 1001);
		em.close();

		 em = emf.createEntityManager();
		 EntityTransaction tx = em.getTransaction();
		 tx.begin();
		 emp.setEmpSal(8000);
		 em.merge(emp);
		 tx.commit();
		 em.close();
		
	}

}
