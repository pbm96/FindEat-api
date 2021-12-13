package com.findeat.apirest.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findeat.apirest.models.dao.IRoleDao;
import com.findeat.apirest.models.entity.Role;

@Service
public class RoleServiceImplement implements IRoleService {
	@Autowired
	private IRoleDao roleDao;

	@Override
	public Role getRoleuser() {
		Role userRole = roleDao.findByRole("User");
		return userRole;
	}

	@Override
	public Role getRoleBusiness() {
		Role userRole = roleDao.findByRole("Business");
		return userRole;
	}

	@Override
	public Role getRoleAdmin() {
		Role userRole = roleDao.findByRole("Admin");
		return userRole;
	}

}
