package com.niit.shoppingcartbackend;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;



public class TestCaseSupplier {


		
		    @Autowired
			SupplierDAO supplierDAO;
		    
		    @Autowired
		    Supplier supplier;
		    
		    AnnotationConfigApplicationContext context;
		    
		    
		    @Before
		    public void init()
		    {
		    	context= new AnnotationConfigApplicationContext();
		    	context.scan("com.niit");
		    	context.refresh();
		    	
		    	supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		    	supplier = (Supplier) context.getBean("supplier");
		    	
		    }
		    
		    @Test
		    public void supplierListTestCase()
		    {
		    	List<Supplier> list = supplierDAO.list();
		    	int rowCount= list.size();
		    	assertEquals("Category List Test Case ", rowCount,3);
		    	
		    	
		    }
		    @Test
		    public void supplierAddTestcase()
		    {
		    	supplier.setId("SUP04");
		    	supplier.setName("vcbvj");
		    	supplier.setAddress("tfehiwj");
		    	
		    	boolean flag= supplierDAO.save(supplier);
		    	assertEquals(flag,true);
		    	
		    	
		    	
		    }	    
			@Test
			public void supplierGetTestCase()
			{
				supplier= supplierDAO.get("SUP01");
				System.out.println(supplier.getName());
				System.out.println(supplier.getAddress());
				assertEquals(supplier.getName(),"SUPabc");
			}
			@Test
			public void supplierDeleteTestCase()
			{	
				supplier.setId("SUP03");
				
			boolean flag=	supplierDAO.delete(supplier);
			
			assertEquals("supplierDeleteTestCase", flag,true);
			}
	}


