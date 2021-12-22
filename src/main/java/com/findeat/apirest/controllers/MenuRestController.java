package com.findeat.apirest.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.findeat.apirest.dto.web.CreateMenuDTO;
import com.findeat.apirest.dto.web.UuidDTO;
import com.findeat.apirest.models.services.IMenuService;

@RestController
@RequestMapping("/menu")
public class MenuRestController {
	@Autowired
	private IMenuService menuService;

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody CreateMenuDTO createMenuDto) {
		return menuService.create(createMenuDto);
	}

	@PostMapping("/get-menu")
	public ResponseEntity<?> getMenu(HttpServletRequest request, @RequestBody UuidDTO uuidDto) {
		return menuService.getMenu(uuidDto);
	}
}