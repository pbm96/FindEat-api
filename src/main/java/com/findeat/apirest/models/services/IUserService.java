package com.findeat.apirest.models.services;

import com.findeat.apirest.models.entity.User;

public interface IUserService {
	
	public User findByUsername(String username);

}
