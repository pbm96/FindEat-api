package com.findeat.apirest.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity()
@Table(name = "categories")
public class Category implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
	
	@ManyToMany
	@JoinTable(
			  name = "category_business", 
			  joinColumns = @JoinColumn(name = "business_id"), 
			  inverseJoinColumns = @JoinColumn(name = "category_id"))
	private List<Business> business;
	
	private String uuid;
	private String name;
	
	 
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public List<Business> getBusiness() {
		return business;
	}
	public void setBusiness(List<Business> business) {
		this.business = business;
	}


	private static final long serialVersionUID = 1L;



	
}
