package com.findeat.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.findeat.apirest.models.entity.Business;
import com.findeat.apirest.models.entity.User;

public interface IBusinessDAO extends CrudRepository<Business, Long> {

	public Business findByUser(User user);
}
