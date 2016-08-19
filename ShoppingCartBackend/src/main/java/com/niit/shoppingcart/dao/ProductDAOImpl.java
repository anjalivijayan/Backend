package com.niit.shoppingcart.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.niit.shoppingcart.model.Product;
@Transactional
@Repository(value="productDAO")
public class ProductDAOImpl implements ProductDAO{
	
	private static final Logger log = LoggerFactory.getLogger(ProductDAOImpl.class);
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory= sessionFactory;
	}
	

public boolean save(Product product){

	
		try {
			log.debug("Starting of the method save");
	
			sessionFactory.getCurrentSession().save(product);
			
			log.debug("Ending of the method save");
			return true;
		} catch (Exception e) {
			log.error("Exception occured in save method" + e.getMessage());
			e.printStackTrace();
			return false;
		}
}
	

	public boolean update(Product product){
		try {
			log.debug("Starting of the method save");
			sessionFactory.getCurrentSession().update(product);
			log.debug("Ending of the method save");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Exception occured in update method" + e.getMessage());
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean delete(Product product){
		try {
			log.debug("Starting of the method get");
			sessionFactory.getCurrentSession().delete(product);
			log.debug("Ending of the method get");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Exception occured in delete method" + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public  Product get(String id){
		log.debug("Starting of the method get");
		log.info("Trying to get product based on id:"+ id);
		String hql = "from Product where id= "+"'"+id+"'";
		
		log.info("The hql query is:"+id);
		 Query query=sessionFactory.getCurrentSession().createQuery(hql);
		 @SuppressWarnings("deprecation")
		List<Product> list=   query.list();
		if(list==null || list.isEmpty())
		{
			log.info("No products are available with this id:"+id);
			return null;
			
		}
		else
		{
			return list.get(0);
			
		}
	}
	
	public List<Product> list()
	{
		log.debug("Starting of the method List");
		String hql="from Product";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("Ending of the method List");
		List<Product> list= query.list();
		if(list==null || list.isEmpty())
		{
			log.info("No products are available");
		}
		return list;
		
		
	}
	
	
	
	
	
	
	
}
