package com.findeat.apirest.models.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.findeat.apirest.models.entity.Business;
import com.findeat.apirest.models.entity.Menu;

public interface IMenuDAO extends CrudRepository<Menu, Long> {

	public Menu findByBusiness(Business business);

	public Optional<Menu> findById(Long id);

}
