package com.vam.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.vam.entity.Emp;

public class EmpDao implements DaoI {

	private static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("myjpa");

	}

	@Override
	public int addEmployee(Emp emp) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(emp);
		tx.commit();
		em.close();
		return 1;
	}

	@Override
	public int updateEmployee(int eid, double sal) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Emp emp = em.find(Emp.class, eid);
		if (emp != null) {
			emp.setEmpSal(sal);
			em.persist(emp);
		}
		tx.commit();
		em.close();
		return 1;
	}

	@Override
	public int removeEmployee(int eid) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Emp emp = em.find(Emp.class, eid);
		if (emp != null) {
			em.remove(emp);
		}
		tx.commit();
		em.close();
		return 1;
	}

	@Override
	public Emp getEmployee(int eid) {
		EntityManager em = emf.createEntityManager();
		Emp emp = (Emp) em.find(Emp.class, eid);
		return emp;
	}

	@Override
	public List<Emp> getEmployees(String desig) {
		String jpql = "from Emp where desig=?1";
		EntityManager em = emf.createEntityManager();
		Query qry = em.createQuery(jpql);
		qry.setParameter(1, desig);
		List<Emp> lst = qry.getResultList();
		em.close();
		return lst;
	}

	@Override
	public List<Emp> getEmployees(double minsal, double maxsal) {
		String jpql = "from Emp where empSal between :min and :max";
		EntityManager em = emf.createEntityManager();
		Query qry = em.createQuery(jpql);
		qry.setParameter("min", minsal);
		qry.setParameter("max", maxsal);
		List<Emp> lst = qry.getResultList();
		em.close();
		return lst;
	}

	@Override
	public List<Object[]> getEmpNamendSal() {
		String jpql = "select empName, empSal from Emp";
		EntityManager em = emf.createEntityManager();
		Query qry = em.createQuery(jpql);
		List<Object[]> lst = qry.getResultList();
		em.close();
		return lst;
	}

	@Override
	public Object[] getSumMaxMinSal() {
		String jpql = "select sum(empSal), max(empSal), min(empSal) from Emp";
		EntityManager em = emf.createEntityManager();
		Query qry = em.createQuery(jpql);
		Object[] arr = (Object[]) qry.getSingleResult();
		em.close();
		return arr;

	}

	@Override
	public List<Object[]> getSumMaxMinSalEachDesig() {
		String jpql = "select desig, sum(empSal),max(empSal), min(empSal) from Emp group by desig";
		EntityManager em = emf.createEntityManager();
		Query qry = em.createQuery(jpql);
		List<Object[]> lst = qry.getResultList();
		em.close();
		return lst;
	}

}
