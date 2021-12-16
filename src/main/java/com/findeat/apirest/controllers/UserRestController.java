package com.findeat.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.findeat.apirest.models.entity.User;
import com.findeat.apirest.models.services.IUserService;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private IUserService userService;

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody User user) {
		return userService.RegisterUser(user);
	}

	@PostMapping("/register-business")
	public ResponseEntity<?> registerBusiness(@RequestBody User user) {
		return userService.RegisterBusiness(user);
	}

}
