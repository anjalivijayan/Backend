package com.niit.shoppingcart.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Entity
@Table(name="userdetails")
@Component
public class UserDetails implements Serializable{
	
	
	@NotNull
	@Id
	private String id;
	
	
	 @Size(min=3, max=10)
	 private String name; 
	 
	 
	 @Size(min=3, max=10)
	 private String password;
	 
	 
	 @Column(name = "role")
	private String role;
	
	
	private String mail;
	private String contact;
	private String address;
	
	@OneToMany(mappedBy = "user" , fetch = FetchType.EAGER)
	private Set<UserDetails> user ;
	
	
	
	public Set<UserDetails> getCart() {
		return user;
	}
	public void setCart(Set<UserDetails> cart) {
		this.user = cart;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	

}
