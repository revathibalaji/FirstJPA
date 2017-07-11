package com.vam.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.vam.entity.StuCourseEntity;
import com.vam.entity.StuCourseKey;

public class CompositeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("myjpa");
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			StuCourseKey key = new StuCourseKey("S1002","java");
			StuCourseEntity entity = new StuCourseEntity();
			entity.setKey(key);
			entity.setMarks(56);
			em.persist(entity);
			tx.commit();
			System.out.println("row added");
		} catch (Exception ex) {
            tx.rollback();
		}finally{
			em.close();
		}

	}

}
