package com.findeat.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.findeat.apirest.models.entity.Role;

public interface IRoleDao extends CrudRepository<Role, Long> {

	public Role findByRole(String role);

}
