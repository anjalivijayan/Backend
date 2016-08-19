package com.niit.shoppingcart.dao;

	import java.util.List;

	import org.hibernate.Query;
	import org.hibernate.SessionFactory;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;

	import com.niit.shoppingcart.model.Supplier;

	@Transactional
	@Repository(value="supplierDAO")
	public class SupplierDAOImpl implements SupplierDAO{
		
		@Autowired
		private SessionFactory sessionFactory;
		
		public SupplierDAOImpl(SessionFactory sessionFactory){
			this.sessionFactory= sessionFactory;
		}
		

	public boolean save(Supplier supplier){

		
			try {

			
	sessionFactory.getCurrentSession().save(supplier);
				
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
	}
		
		
		public boolean update(Supplier supplier){
			try {
				sessionFactory.getCurrentSession().update(supplier);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
		}

		public boolean delete(Supplier supplier){
			try {
				sessionFactory.getCurrentSession().delete(supplier);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		
		@SuppressWarnings("unchecked")
		public  Supplier get(String id){
			
			String hql = "from Supplier where id= "+"'"+id+"'";
			 Query query=sessionFactory.getCurrentSession().createQuery(hql);
			 @SuppressWarnings("deprecation")
			List<Supplier> list=   query.list();
			if(list==null || list.isEmpty())
			{
				return null;
				
			}
			else
			{
				return list.get(0);
				
			}
		}
		public List<Supplier>  list(){
			String hql="from Supplier";
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			return query.list();
			
		}
		
	}
