package com.vam.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.vam.dao.DaoI;
import com.vam.dao.EmpDao;
import com.vam.entity.Emp;

public class Employee {

	public static void main(String[] args) throws ParseException{
		DaoI dao = new EmpDao();
		Emp emp = new Emp();

		//add employee
		emp.setEmpId(1002);
		emp.setEmpName("ram");
		emp.setEmpSal(6000);
		emp.setDesig("hr");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dt = sdf.parse("05/06/2011");
		emp.setDoj(dt);
		emp.setEmail("ram@gmail.com");
		dao.addEmployee(emp);
		System.out.println("employee added...");

		//delete
		int row=dao.removeEmployee(1002);
		System.out.println(row);
		if(row==1){
			System.out.println("deleted successfully");
		}

		//update
		int row1=dao.updateEmployee(1002,20000);
		System.out.println(row);
		if(row1==1){
			System.out.println("update successfully");
		}

		//getEmployee
		Emp emp2=new Emp();	
		emp2=dao.getEmployee(1002);
		System.out.println(emp2);


		//Allemployees
		List<Emp> emp1=dao.getEmployees("hr");		
		if(emp1!=null){
			System.out.println(emp1);
		}

		//aggration
		Object[] arr = dao.getSumMaxMinSal();
		System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);

		//groupby
		List<Object[]> lst =  dao.getSumMaxMinSalEachDesig();
		for(Object[] arr1: lst){
			System.out.println(arr1[0] + " " + arr1[1]+ " " + arr1[2] + " " + arr1[3]);
		}

		//ViewEmpNamendSal 

		List<Object[]> lst1 =  dao.getEmpNamendSal();
		for(Object[] arr2: lst1){
			System.out.println(arr2[0] + " " + arr2[1]);
		}
		// ViewEmpBySalRange 

		List<Emp> lst2 = dao.getEmployees(10000, 55000);
		for(Emp emp3: lst2){
			System.out.println(emp3);
		}
		// ViewEmpByDesig 
		List<Emp> lst3 = dao.getEmployees("tester");
		for(Emp emp4: lst3){
			System.out.println(emp4);

		}

		//ViewEmployeeByID 				
		Emp emp5 = dao.getEmployee(1006);
		System.out.println(emp5);
	}

}

