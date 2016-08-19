package com.niit.shoppingcart.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Category;

@Transactional
@Repository(value="categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CategoryDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory= sessionFactory;
	}
	

public boolean save(Category category){

	
		try {

		
sessionFactory.getCurrentSession().save(category);
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
}
	
	
	public boolean update(Category category){
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean delete(Category category){
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public  Category get(String id){
		
		String hql = "from Category where id= "+"'"+id+"'";
		 Query query=sessionFactory.getCurrentSession().createQuery(hql);
		 @SuppressWarnings("deprecation")
		List<Category> list=   query.list();
		if(list==null || list.isEmpty())
		{
			return null;
			
		}
		else
		{
			return list.get(0);
			
		}
	}
	public List<Category>  list(){
		String hql="from Category";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
		
	}
	
	
	
	
	
	
	
}
