package com.findeat.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.findeat.apirest.dto.web.AutocompletePlacesDTO;
import com.findeat.apirest.dto.web.UuidDTO;
import com.findeat.apirest.models.entity.Business;
import com.findeat.apirest.models.services.IBusinessService;

@RestController
@RequestMapping("/business")
public class BusinessRestController {
	@Autowired
	private IBusinessService businessService;

	@PostMapping("/getBusinessByUser")
	public Business register(@RequestBody UuidDTO peticion) {
		return businessService.findByUser(peticion.getUuid());
	}

	@PostMapping("/get-places")
	public ResponseEntity<?> registerBusiness(@RequestBody AutocompletePlacesDTO autocompletePlacesDTO) {
		return businessService.findPlaces(autocompletePlacesDTO);
	}

}
