/*package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Product;



public class TestCaseProduct {

	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		productDAO =  (ProductDAO) context.getBean("productDAO");
		product =  (Product) context.getBean("product");
		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		
		
		
		
	}*/
			
	
	/*@Test
	public void deleteProductTestCase()
	{	
		product.setId("Mob_01");
		
	boolean flag=	productDAO.delete(product);
	
	assertEquals("delete product", flag,false);

		
	}
	*/
	/*@Test
	public void addProductTestCase()
	{
		product.setId("01");
		product.setName("QUEEN BED");
		product.setDescription("BED");
		product.setPrice(2000);
		product.setCategory(categoryDAO.get("CATE11"));
		product.setSupplier(supplierDAO.get("SUP011"));
		productDAO.saveOrUpdate(product);

		
		/*boolean flag= productDAO.save(product);
    	assertEquals(flag,true);*/
    	
		
		//assertEquals("addProductTestCase", productDAO.saveOrUpdate(product));
		
	/*}
	
	@Test
	public void listProductTestCase()
	{
		assertEquals("listProductTestCase", productDAO.list().size(),1);
		
	}
	

	
	
	@Test
	public void getProductTestCase()
	{
		assertEquals("getProductTestCase", productDAO.get("MOB_01"),(null));
	}
	
}
*/