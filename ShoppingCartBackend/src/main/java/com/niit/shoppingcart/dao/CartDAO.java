package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Cart;

public interface CartDAO {
	
public Cart get(int id);
	
	public void saveOrUpdate(Cart cart);

	public List<Cart> list();

	public List<Cart> userCartList(String uID);
	
	public Cart getByUserId(String uID);

	public String delete(int id);
	
	public long getTotalAmount(String id);
	
	public void checkOut(String uID);
	
}
