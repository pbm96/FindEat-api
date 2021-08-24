package com.findeat.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="users")
public class User implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String uuid;
		
	@Column(unique = true, length=9)
	private Integer phone;
	
	@Column(unique = true)
	private String email;
	
	private String name;
	@Column(length = 60)
	private String password;

	@Column(name="email_confirmed")
	private Boolean emailConfirmed;
	
	@Column(name="created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	private String adress;
	private String latitude;
	private String longitude;
	@ManyToOne()
    @JoinColumn(name = "role_id")
	private Role role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Boolean getEmail_confirmed() {
		return emailConfirmed;
	}

	public void setEmail_confirmed(Boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}

	public Date getCreated_at() {
		return createdAt;
	}

	public void setCreated_at(Date createdAt) {
		this.createdAt = createdAt;
	}
	

	private static final long serialVersionUID = 1L;

}
