package com.findeat.apirest.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.findeat.apirest.dto.web.EditPlateDTO;
import com.findeat.apirest.dto.web.idDTO;
import com.findeat.apirest.models.services.IPlateService;

@RestController
@RequestMapping("/plate")
public class PlateRestController {

	@Autowired
	private IPlateService plateService;

	@PostMapping("/edit-plate")
	public ResponseEntity<?> editPlate(HttpServletRequest request, @RequestBody EditPlateDTO editPlateDTO) {
		return plateService.editPlate(editPlateDTO);
	}

	@PostMapping("/delete-plate")
	public ResponseEntity<?> deletePlate(HttpServletRequest request, @RequestBody idDTO idDTO) {
		return plateService.deletePlate(idDTO.getId());
	}

}
