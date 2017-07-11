package com.vam.dao;

import java.util.List;

import com.vam.entity.Emp;
import com.vam.entity.Product;

public interface DaoI {

	public int addEmployee(Emp emp);
	public int updateEmployee(int eid, double sal);
	public int removeEmployee(int eid);
	public Emp getEmployee(int eid);
	public List<Emp> getEmployees(String desig);
	public List<Emp> getEmployees(double minsal, double maxsal);
	public List<Object[]> getEmpNamendSal();
	public Object[] getSumMaxMinSal();
	public List<Object[]> getSumMaxMinSalEachDesig();
	
	
	
}
