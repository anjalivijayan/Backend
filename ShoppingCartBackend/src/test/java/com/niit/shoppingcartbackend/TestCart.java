package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.UserDetails;

public class TestCart {

public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		CartDAO cartDAO = (CartDAO) context.getBean("cartDAO");
		Cart cart = (Cart) context.getBean("cart");
		UserDetailsDAO userDAO = (UserDetailsDAO) context.getBean("userDetailsDAO");
		ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
		

		
		//Product pr=productDAO.get("p14");
		cart.setId(02);
		cart.setTotal(3000);
		cart.setProductName("Lamp");
		cart.setQuantity(2);
		cart.setStatus('N');
		cart.setPrice(10000);
		cart.setUser(userDAO.get("U234"));
		cart.setProduct(productDAO.get("P12"));
		//cart.setUser(us);
		//cart.setProduct(p);
		cartDAO.saveOrUpdate(cart);
	
	}

}
	
	
