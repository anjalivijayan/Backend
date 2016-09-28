package com.niit.shoppingcart.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;

@Transactional
@Repository(value="categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{
	
	private static final Logger log = LoggerFactory.getLogger(CategoryDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public CategoryDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory= sessionFactory;
	}
	

public boolean save(Category category){

	
		try {
			log.debug("Start of method Save");
		
			sessionFactory.getCurrentSession().save(category);
			
			log.debug("End of method save");
			return true;
			}
		 catch (Exception e) {
			log.error("Exception" + e.getMessage());
			e.printStackTrace();
			return false;
		}
}
	
	
	public boolean update(Category category){
		try {
			log.debug("Start of method Update");
			
			sessionFactory.getCurrentSession().update(category);
			
			log.debug("End of method Update");
			return true;
		} catch (Exception e) {
			log.error("Exception" + e.getMessage());
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean delete(Category category){
		try {
			log.debug("Start of method Delete");
			
			sessionFactory.getCurrentSession().delete(category);
			
			log.debug("End of method Delete");
			return true;
		} catch (Exception e) {
			log.error("Exception" + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public  Category get(String id){
		
		log.debug("Start of method get");
		log.info("Try to get product based on id:"+ id);
		String hql = "from Category where id= "+"'"+id+"'";
		log.info("The hql query is:"+id);
		 Query query=sessionFactory.getCurrentSession().createQuery(hql);
		 @SuppressWarnings("deprecation")
		List<Category> list=   query.list();
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
	public List<Category>  list(){
		log.debug("Start of method List");
		String hql="from Category";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("End of method List");
		List<Category> list= query.list();
		if(list==null || list.isEmpty())
		{
			log.info("No products are available");
		}
		
		return list;
		
		
	}


	
		@Transactional
		public Category getByName(String name) {
			String hql = "from Category where name=" + "'"+ name +"'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<Category> listCategory = (List<Category>) query.list();
			
			if (listCategory != null && !listCategory.isEmpty()) {
				return listCategory.get(0);
			}
			
			return null;
	
	}
	
	
	
	
	
	
	
}
