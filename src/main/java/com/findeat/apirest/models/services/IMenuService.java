package com.findeat.apirest.models.services;

import org.springframework.http.ResponseEntity;

import com.findeat.apirest.dto.web.CreateMenuDTO;
import com.findeat.apirest.models.entity.Menu;

public interface IMenuService {

	public ResponseEntity<?> create(CreateMenuDTO createMenuDto);

	public ResponseEntity<?> getMenuByBusiness(String uuid);

	public Menu getMenuById(Long id);

}
