package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Cart;

public interface CartDAO {
	
public Cart get(String id);
	
	public void saveOrUpdate(Cart cart);

	public List<Cart> list();

	public List<Cart> userCartList(String user_id);
	
	public Cart getByUserId(String user_id);

	public boolean delete(Cart cart);
	
	public long getTotalAmount(String id);
	
	public void checkOut(String user_id);
	
}
