package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

public class TestCaseProduct {

	@Autowired
	
	ProductDAO productDAO;
	
	@Autowired
	
	Product product;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	
	public void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		productDAO =  (ProductDAO) context.getBean("productDAO");
		
		product = (Product) context.getBean("product");
	}
			
	
	@Test
	public void deleteProductTestCase()
	{	
		product.setId("Mob_01");
		
	boolean flag=	productDAO.delete(product);
	
	assertEquals("delete product", flag,false);
		
	}
	
	@Test
	public void addProductTestCase()
	{
		product.setId("Mob_05");
		product.setName("sfgdkjfh");
		product.setDescription("ehd");
		product.setPrice(20000);
		
		/*boolean flag= productDAO.save(product);
    	assertEquals(flag,true);*/
    	
		
		assertEquals("addProductTestCase", productDAO.save(product));
	}
	
	@Test
	public void listProductTestCase()
	{
		assertEquals("listProductTestCase", productDAO.list().size(),1);
		
	}
	
	@Test
	public void updateProductTestCase()
	{
		product.setId("Mob_03");
		
		product.setPrice(6000);
		product.setDescription("laptop");
		assertEquals("updateProductTestCase", productDAO.update(product),true);
		
	}
	
	@Test
	public void getProductTestCase()
	{
		assertEquals("getProductTestCase", productDAO.get("MOB_01"),(null));
	}
	
}
