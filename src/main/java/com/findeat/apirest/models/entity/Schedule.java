package com.findeat.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity()
@Table(name = "schedules")
public class Schedule implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private boolean monday;
	private boolean tuesday;
	private boolean wednesday;
	private boolean thursday;
	private boolean friday;
	private boolean saturday;
	private boolean sunday;
	
	@Column(name="closing_time")
	private String closingTime;
	
	@Column(name="opening_time")
	private String openingTime;
	
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "schedule_id")
	private Business business;	

	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public boolean isMonday() {
		return monday;
	}


	public void setMonday(boolean monday) {
		this.monday = monday;
	}


	public boolean isTuesday() {
		return tuesday;
	}


	public void setTuesday(boolean tuesday) {
		this.tuesday = tuesday;
	}


	public boolean isWednesday() {
		return wednesday;
	}


	public void setWednesday(boolean wednesday) {
		this.wednesday = wednesday;
	}


	public boolean isThursday() {
		return thursday;
	}


	public void setThursday(boolean thursday) {
		this.thursday = thursday;
	}


	public boolean isFriday() {
		return friday;
	}


	public void setFriday(boolean friday) {
		this.friday = friday;
	}


	public boolean isSaturday() {
		return saturday;
	}


	public void setSaturday(boolean saturday) {
		this.saturday = saturday;
	}


	public boolean isSunday() {
		return sunday;
	}


	public void setSunday(boolean sunday) {
		this.sunday = sunday;
	}


	public String getClosingTime() {
		return closingTime;
	}


	public void setClosingTime(String closingTime) {
		this.closingTime = closingTime;
	}


	public String getOpeningTime() {
		return openingTime;
	}


	public void setOpeningTime(String openingTime) {
		this.openingTime = openingTime;
	}


	public Business getBusiness() {
		return business;
	}


	public void setBusiness(Business business) {
		this.business = business;
	}


	private static final long serialVersionUID = 1L;

}
