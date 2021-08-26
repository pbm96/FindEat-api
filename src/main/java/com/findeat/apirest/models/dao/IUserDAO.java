package com.findeat.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.findeat.apirest.models.entity.User;

public interface IUserDAO extends CrudRepository<User, Long>{
	
	public User findByUsername(String username);
	
	

}
