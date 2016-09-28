package com.niit.shoppingcart.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.UserDetails;

@Transactional
@Repository(value="userDetailsDAO")
public class UserDetailsDAOImpl implements UserDetailsDAO{
	
	private static final Logger log= LoggerFactory.getLogger("UserDetailsDAOImpl.class");
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDetailsDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory= sessionFactory;
	}
	

public boolean save(UserDetails userdetails){

		try {
			log.debug("Start of method Save");
			
			sessionFactory.getCurrentSession().save(userdetails);
			
			log.debug("End of method Save");
			return true;
		} catch (Exception e) {
			log.error("Exception" + e.getMessage());
			
			e.printStackTrace();
			
			return false;
		}
	
	
	
	
}
	

	public boolean update(UserDetails userdetails){
		try {
			log.debug("Start of method Update");
			
			sessionFactory.getCurrentSession().update(userdetails);
			
			log.debug("End of method Update");
			return true;
		} catch (Exception e) {
			
			log.error("Exception" + e.getMessage());
			
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Transactional
	public void saveOrUpdate(UserDetails userDetails) {
		sessionFactory.getCurrentSession().saveOrUpdate(userDetails);

	}

	
	

	public boolean delete(UserDetails userdetails){
		try {
			log.debug("Start of method Delete");
			
			sessionFactory.getCurrentSession().delete(userdetails);
			
			log.debug("End of method Delete");
			return true;
		} catch (Exception e) {
			log.error("Exception" + e.getMessage());
			
			e.printStackTrace();
			
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public  UserDetails get(String id){
		
		log.debug("Start of method get");
		log.info("Try to get product based on id:"+ id);
		
		String hql = "from UserDetails where id= "+"'"+id+"'";
		
		log.info("The hql query is:"+id);
		
		 Query query=sessionFactory.getCurrentSession().createQuery(hql);
		 @SuppressWarnings("deprecation")
		List<UserDetails> list=   query.list();
		if(list==null || list.isEmpty())
		{
			log.info("No products available with this id:"+id);
			return null;
			
		}
		else
		{
			return list.get(0);
			
		}
	
	}
	
	
	@Transactional
	public List<UserDetails>  list(){
		
		log.debug("Start of method List");
		String hql="from UserDetails";
		log.debug("End of method List");
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<UserDetails> list= query.list();
		if(list==null || list.isEmpty())
		{
			log.info("No products are available");
		}
		return list;
		
		
	}
	


public boolean isValidUser(String id,String password )
{
	String hql = "From UserDetails where id='" + id +"' and " + " password='" + password+"'";
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<UserDetails> list = (List<UserDetails>) query.list();
	
	if(list !=null && !list.isEmpty())
	{
		return true;
		
	}
		return false;
		
}
	
}

