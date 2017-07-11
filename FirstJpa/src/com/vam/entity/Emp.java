package com.vam.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="employee")
public class Emp {
	
	@Id
	@Column(name="emp_id")
	private int empId;
	
	@Column(name="emp_name", nullable=false)
	private String empName;
	
	@Column(name="emp_sal")
	private double empSal;
	
	@Column(name="emp_desig", length=20)
	private String desig;
	
	@Temporal(TemporalType.DATE)
	@Column(name="emp_doj")
	private Date doj;
	
	@Column(name="emp_email", length=50, unique=true)
	private String email;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
		
		return empId + " " + empName + " " + empSal + " " + desig + " " + sdf.format(doj) + " " + email;
	}
	
	
	

}
