package com.niit.shoppingcart.model;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Supplier {
	
	@Id
	private String id;
	
	@NotNull
	private String name;
	
	
	private String address;
	
	
	
	@OneToMany(mappedBy="supplier",fetch=FetchType.EAGER )
	private Set<Product> products;
	
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
