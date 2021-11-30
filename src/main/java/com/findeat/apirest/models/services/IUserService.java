package com.findeat.apirest.models.services;

import org.springframework.http.ResponseEntity;

import com.findeat.apirest.models.entity.User;

public interface IUserService {

	public User findByUsername(String username);

	public ResponseEntity<?> RegisterUser(User user);

}
