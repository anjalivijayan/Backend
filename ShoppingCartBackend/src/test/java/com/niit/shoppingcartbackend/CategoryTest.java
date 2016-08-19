package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;


public class CategoryTest {

	@SuppressWarnings("resource")
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit");

		context.refresh();
		
		
		
		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		
		
		Category category= (Category) context.getBean("category");
		
		
	category.setId("CG01");
		
		category.setName("CGPhone");
		
		category.setDescription("This is iPhone");
	/*categoryDAO.save(category);*/
	
		
		if (categoryDAO.save(category)== true)
		{
			System.out.println("Category created successfully");
		}
		else
		{
			System.out.println("Not able to create category");
		}
		
	}
	
	
	
	
}
