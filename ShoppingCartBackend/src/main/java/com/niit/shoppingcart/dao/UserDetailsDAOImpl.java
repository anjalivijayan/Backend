package com.niit.shoppingcart.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.UserDetails;

@Transactional
@Repository(value="userDetailsDAO")
public class UserDetailsDAOImpl implements UserDetailsDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDetailsDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory= sessionFactory;
	}
	

public boolean save(UserDetails userdetails){

		try {
			sessionFactory.getCurrentSession().save(userdetails);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
}
	

	public boolean update(UserDetails userdetails){
		try {
			sessionFactory.getCurrentSession().update(userdetails);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean delete(UserDetails userdetails){
		try {
			sessionFactory.getCurrentSession().delete(userdetails);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public  UserDetails get(String id){
		
		String hql = "from UserDetails where id= "+"'"+id+"'";
		 Query query=sessionFactory.getCurrentSession().createQuery(hql);
		 @SuppressWarnings("deprecation")
		List<UserDetails> list=   query.list();
		if(list==null || list.isEmpty())
		{
			return null;
			
		}
		else
		{
			return list.get(0);
			
		}
	}
	
	public List<UserDetails>  list(){
		String hql="from UserDetails";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
		
	}
	
	
	
	
	
	
	
}

