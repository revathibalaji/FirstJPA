package com.vam.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.vam.entity.Emp;
import com.vam.entity.Product;

public class ProductDao implements ProductDaoI{

	private static EntityManagerFactory emf;

	static{
		emf= Persistence.createEntityManagerFactory("myjpa");

	}

	@Override
	public int addProduct(Product product) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(product);
		tx.commit();
		em.close();
		return 1;
	}

	@Override
	public int updateProduct(int pid, double pMax) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Product product = em.find(Product.class,  pid);
		if ( product != null){
			product.setpMax(pMax);
			em.persist(product);
		}
		tx.commit();
		em.close();
		return 1;
	}

	@Override
	public int removeProduct(int pid) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Product product = em.find(Product.class,  pid); 
		if ( product != null){
				em.remove(product);
			}
		tx.commit();
		em.close();
		return 1;
	}

	@Override
	public Product getProduct(int pid) {
		EntityManager em = emf.createEntityManager();
		Product product = (Product)em.find(Product.class, pid);
		return product;
	}

	@Override
	public List<Product> getProducts(String category) {
		String jpql="from Emp where category=?1";
		EntityManager em = emf.createEntityManager();
		Query qry=em.createQuery(jpql);
		qry.setParameter(1, category);
		List<Product> lst = qry.getResultList();
		em.close();
		return lst;
	}
	

	@Override
	public List<Object[]> getProductNamendCategory() {
		String jpql = "select empName, empSal from Emp";
		EntityManager em = emf.createEntityManager();
		Query qry = em.createQuery(jpql);
		List<Object[]> lst = qry.getResultList();
		em.close();
		return lst;
	}
	@Override
	public List<Product> getProducts(double min, double max)  {
        String jpql = "from P where empSal between :min and :max";
		EntityManager em = emf.createEntityManager();
		Query qry = em.createQuery(jpql);
		qry.setParameter("min", min);
		qry.setParameter("max", max);
		List<Product> lst = qry.getResultList();
		em.close();
		return lst;
	}

	
}
