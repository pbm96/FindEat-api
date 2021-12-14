package com.findeat.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.findeat.apirest.models.entity.Business;

public interface IBusinessDAO extends CrudRepository<Business, Long> {

	public Business findByUuid(String uuid);
}
