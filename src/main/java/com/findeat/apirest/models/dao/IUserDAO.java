package com.findeat.apirest.models.dao;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.findeat.apirest.models.entity.User;

public interface IUserDAO extends CrudRepository<User, Long>{
	
	public User findByUsername(String username);
	
	public User findByEmail(String email);
	
	public User findByPhone(Integer phone);
	
	public User findByUuid(UUID uuid);
	
	



}
