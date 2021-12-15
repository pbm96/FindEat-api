package com.findeat.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity()
@Table(name = "ratings")
public class Rating implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String uuid;
	private String comment;
	private Float score;

	@Column(name = "business_answer")
	private String businessAnswer;

	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne()
	@JoinColumn(name = "business_id")
	private Business business;

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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public String getBusinessAnswer() {
		return businessAnswer;
	}

	public void setBusinessAnswer(String businessAnswer) {
		this.businessAnswer = businessAnswer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	private static final long serialVersionUID = 1L;

}
