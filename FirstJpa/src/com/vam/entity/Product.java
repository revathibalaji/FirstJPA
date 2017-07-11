package com.vam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@Column(name="p_id")
	private int pId;
	
	@Column(name="p_name", nullable=false)
	private String pName;
	
	@Column(name="p_min")
	private double pMin;
	
	@Column(name="p_max")
	private double pMax;
	
	@Column(name="p_category", length=20)
	private String category;

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public double getpMin() {
		return pMin;
	}

	public void setpMin(double pMin) {
		this.pMin = pMin;
	}

	public double getpMax() {
		return pMax;
	}

	public void setpMax(double pMax) {
		this.pMax = pMax;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pName=" + pName + ", pMin=" + pMin
				+ ", pMax=" + pMax + ", category=" + category + "]";
	}
	
		
	
	
	
	
	
	

}
