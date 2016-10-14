package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Supplier;



public interface SupplierDAO {

	
	public boolean saveOrUpdate(Supplier supplier);
	
	public boolean delete(Supplier supplier);
	
	public  Supplier get(String id);
	
	public Supplier getByName(String name);

	public List<Supplier>  list();
	

}
	