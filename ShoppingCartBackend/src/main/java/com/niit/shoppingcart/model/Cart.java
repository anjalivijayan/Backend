package com.niit.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Cart {
	
	
	
	//@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Id 
	private int id;
	
	
	private int total;
	
	private String productName;
	private int price;
	private int quantity;
	private char status;
	
	
	@Transient
	@ManyToOne
	@JoinColumn(name = "user_id",nullable = true, updatable = true, insertable = true)
	private UserDetails user;
	
	
	
	@Transient
	@ManyToOne
	@JoinColumn(name = "product_id",nullable = true, updatable = true, insertable = true)
    private Product uproducts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	public Product getProduct() {
		return uproducts;
	}

	public void setProduct(Product product) {
		this.uproducts = product;
	}

}
