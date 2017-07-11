package com.vam.dao;

import java.util.List;


import com.vam.entity.Emp;
import com.vam.entity.Product;

public interface ProductDaoI {

	public int addProduct(Product product);
	public int updateProduct(int pid, double pmax);
	public int removeProduct(int pid);
	public Product getProduct(int pid);
	public List<Product> getProducts(String category);
	public List<Product> getProducts(double min, double max);
	public List<Object[]> getProductNamendCategory();
	
}
