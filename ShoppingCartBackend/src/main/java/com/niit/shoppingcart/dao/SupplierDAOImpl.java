package com.niit.shoppingcart.dao;

	import java.util.List;

	import org.hibernate.Query;
	import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;


import com.niit.shoppingcart.model.Supplier;

	@Transactional
	@Repository(value="supplierDAO")
	public class SupplierDAOImpl implements SupplierDAO{
		
		private static final Logger log= LoggerFactory.getLogger(SupplierDAOImpl.class);
		
		@Autowired
		private SessionFactory sessionFactory;
		
		public SupplierDAOImpl(SessionFactory sessionFactory){
			this.sessionFactory= sessionFactory;
		}
		

	public boolean saveOrUpdate(Supplier supplier){

		
			try {
				log.debug("Start of method Save");

				sessionFactory.getCurrentSession().saveOrUpdate(supplier);
				
				log.debug("End of method Save");
				return true;
			} catch (Exception e) {
				log.error("Exception" + e.getMessage());
				e.printStackTrace();
				return false;
			}
	}
		
		
		/*public boolean update(Supplier supplier){
			try {
				log.debug("Start of method Update");
				
				sessionFactory.getCurrentSession().update(supplier);
				
				log.debug("End of method Update");
				return true;
			} catch (Exception e) {
				log.error("Exception" + e.getMessage());
				e.printStackTrace();
				return false;
			}
			
		}*/

		public boolean delete(Supplier supplier){
			try {
				log.debug("Start of method Delete");
				
				sessionFactory.getCurrentSession().delete(supplier);
				
				log.debug("End of method Delete");
				return true;
			} catch (Exception e) {
				log.error("Exception" + e.getMessage());
				
				e.printStackTrace();
				return false;
			}
		}
		
		@SuppressWarnings("unchecked")
		public  Supplier get(String id){
			
			log.debug("Start of method get");
			log.info("Try to get product based on id:"+ id);
			String hql = "from Supplier where id= "+"'"+id+"'";
			log.info("The hql query is:"+id);
			 Query query=sessionFactory.getCurrentSession().createQuery(hql);
			 @SuppressWarnings("deprecation")
			List<Supplier> list=   query.list();
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
		public List<Supplier>  list(){
			
			log.debug("Start of method List");
			String hql="from Supplier";
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			log.debug("End of method List");
			List<Supplier> list= query.list();
			if(list==null || list.isEmpty())
			{
				log.info("No products are available");
			}
			return list;
			
		}
		@Transactional
		public Supplier getByName(String name) {
			String hql = "from Supplier where name=" + "'"+ name+"'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<Supplier> list = (List<Supplier>) query.list();
			
			if (list != null && !list.isEmpty()) {
				return list.get(0);
			}
			
			return null;
	}

		
	}
