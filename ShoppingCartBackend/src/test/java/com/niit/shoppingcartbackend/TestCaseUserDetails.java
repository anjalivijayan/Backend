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
    public void userDetailsListTestCase()
    {
    	List<UserDetails> list = userDetailsDAO.list();
    	int rowCount= list.size();
    	assertEquals("UserDetails List Test Case ", rowCount,1);
    	
    	
    }
    @Test
    public void userDetailsAddTestcase()
    {
    	userDetails.setId("U0168");
    	userDetails.setName("dghdgfhd");
    	userDetails.setAddress("bcgfjd");
    	userDetails.setPassword("gdj455");
    	userDetails.setMail("hdey@gmail.com");
    	userDetails.setContact("9994565425");;
    	
    	boolean flag= userDetailsDAO.save(userDetails);
    	assertEquals(flag,true);
    	
    	
    	
    }	    
	@Test
	public void userdetailsGetTestCase()
	{
		userDetails=userDetailsDAO.get("U0167");
		System.out.println(userDetails.getName());
		System.out.println(userDetails.getAddress());
		System.out.println(userDetails.getMail());
		System.out.println(userDetails.getContact());
		assertEquals(userDetails.getName(),"Anndsf");
		
		
		
	}
	@Test
	public void userdetailsDeleteTestCase()
	{	
		userDetails.setId("U0167");
		
	boolean flag=	userDetailsDAO.delete(userDetails);
	
	assertEquals("userdetailsDeleteTestCase", flag,true);
	}

}
