package com.findeat.apirest.models.services;

import org.springframework.http.ResponseEntity;

import com.findeat.apirest.dto.web.AutocompletePlacesDTO;
import com.findeat.apirest.models.entity.Business;

public interface IBusinessService {

	public Business findByUser(String uuid);

	public Business findByUuid(String uuid);

	public ResponseEntity<?> findPlaces(AutocompletePlacesDTO autocompletePlacesDTO);

}
