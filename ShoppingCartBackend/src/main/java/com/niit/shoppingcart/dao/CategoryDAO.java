package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Category;



public interface CategoryDAO {

	
	public boolean saveOrUpdate(Category category);
	
	public boolean delete(Category category);
	
	public  Category get(String id);
	
	public Category getByName(String name);

	public List<Category>  list();
	
	
	
	
	
	
	
	
	
}
