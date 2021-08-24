package com.findeat.apirest.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity()
@Table(name = "roles")
public class Role implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		private String role;
		
	    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	    @JoinColumn(name = "role_id")
		private List<User> user;	
	
	    
	    
	public long getId() {
			return id;
		}



		public void setId(long id) {
			this.id = id;
		}



		public String getRole() {
			return role;
		}



		public void setRole(String role) {
			this.role = role;
		}



		public List<User> getUser() {
			return user;
		}



		public void setUser(List<User> user) {
			this.user = user;
		}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
