package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;



public class SupplierTest {
	

		@SuppressWarnings("resource")
		
		public static void main(String[] args) {
			
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			
			context.scan("com.niit");

			context.refresh();
			
			
			
			SupplierDAO supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
			
			
			Supplier supplier= (Supplier) context.getBean("supplier");
			
			
			supplier.setId("SUP01");
			
			supplier.setName("SUPabc");
			
			supplier.setAddress("abcd");
		
			supplierDAO.saveOrUpdate(supplier);
			
			/*if (supplierDAO.save(supplier)== true)
			{
				System.out.println("Supplier created successfully");
			}
			else
			{
				System.out.println("Not able to create supplier");
			}*/
		}
}
			
		
		
		
		
		
	