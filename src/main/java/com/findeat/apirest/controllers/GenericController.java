package com.findeat.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.findeat.apirest.models.entity.Role;
import com.findeat.apirest.models.services.IRoleService;

@Controller
public class GenericController {
	@Autowired
	private IRoleService roleService;

	public Role getRoleUser() {
		return roleService.getRoleuser();
	}

}
