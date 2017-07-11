package com.vam.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.vam.dao.DaoI;
import com.vam.dao.EmpDao;
import com.vam.dao.ProductDao;
import com.vam.dao.ProductDaoI;
import com.vam.entity.Emp;
import com.vam.entity.Product;

public class Products {

	public static void main(String[] args) throws ParseException{
		ProductDaoI dao = new ProductDao();
		Product product = new Product();

		//add product
		product.setpId(1008);
		product.setpName("toshiba");
		product.setCategory("computer");
		product.setpMax(20000);
		product.setpMin(1000);

		dao.addProduct(product);
		System.out.println("product added...");

		//delete
		int row=dao.removeProduct(1002);
		System.out.println(row);
		if(row==1){
			System.out.println("deleted successfully");
		}
		else{
			System.out.println("Not Found");
		}

		//update
		int row1=dao.updateProduct(1002,20000);
		System.out.println(row);
		if(row1==1){
			System.out.println("update successfully");
		}

		//getEmployee
		Product product2=new Product();	
		product2=dao.getProduct(1002);
		System.out.println(product2);


		//Allemployees
		List<Product> product1=dao.getProducts("computer");		
		if(product1!=null){
			System.out.println(product1);
		}

		
	}
}
