package com.findeat.apirest.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity()
@Table(name = "Business")
public class Business implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, name = "uuid", nullable = false)
	private String uuid;

	@OneToOne()
	@JoinColumn(name = "schedule_id")
	private Schedule schedule;

	@OneToOne()
	@JsonIgnore
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne()
	@JsonIgnore
	@JoinColumn(name = "menu_id")
	private Menu menu;

	@ManyToMany(mappedBy = "business")
	List<Category> categories;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "business_id")
	private List<Rating> ratings;

	private boolean open;
	private String name;

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

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@PrePersist
	protected void onCreate() {
		setUuid(java.util.UUID.randomUUID().toString());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
