package com.findeat.apirest.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.findeat.apirest.models.entity.Menu;
import com.findeat.apirest.models.entity.Plate;

public interface IPlateDAO extends CrudRepository<Plate, Long> {

	public List<Plate> findByMenu(Menu menu);
}
