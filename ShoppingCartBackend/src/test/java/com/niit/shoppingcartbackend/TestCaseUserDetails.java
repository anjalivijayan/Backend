package com.niit.shoppingcartbackend;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.UserDetails;

public class TestCaseUserDetails {
	
	@Autowired
	UserDetailsDAO userDetailsDAO;
    
    @Autowired
    UserDetails userDetails;
    
    AnnotationConfigApplicationContext context;
    
    
    @Before
    public void init()
    {
    	context= new AnnotationConfigApplicationContext();
    	context.scan("com.niit");
    	context.refresh();
    	
    	userDetailsDAO =  (UserDetailsDAO) context.getBean("userDetailsDAO");
    	userDetails=  (UserDetails) context.getBean("userDetails");
    	
    }
    
     @Test
    public boolean userDetailsListTestCase()
    {
    	List<UserDetails> list = userDetailsDAO.list();
    	int rowCount= list.size();
    	assertEquals("UserDetails List Test Case ", rowCount,1);
    	return true;
    	
    }
    @Test
    public boolean userDetailsAddTestcase()
    {
    	userDetails.setId("U0169");
    	userDetails.setName("bjhghf");
    	userDetails.setAddress("tuqwiodehf");
    	userDetails.setPassword("abcdef");
    	userDetails.setMail("abc@gmail.com");
    	userDetails.setContact("8081144689");;
    	
    	boolean flag= userDetailsDAO.saveOrUpdate(userDetails);
    	assertEquals(flag,true);
    	
    	return true;
    	
    }	    
	@Test
	public boolean userdetailsGetTestCase()
	{
		userDetails=userDetailsDAO.get("U0168");
		System.out.println(userDetails.getName());
		System.out.println(userDetails.getAddress());
		System.out.println(userDetails.getMail());
		System.out.println(userDetails.getContact());
		assertEquals(userDetails.getName(),"Anndsf");
		return true;
		
		
	}
	@Test
	public boolean userdetailsDeleteTestCase()
	{	
		userDetails.setId("U0167");
		
	boolean flag=	userDetailsDAO.delete(userDetails);
	
	assertEquals("userdetailsDeleteTestCase", flag,true);
	
	return true;
	}

}
