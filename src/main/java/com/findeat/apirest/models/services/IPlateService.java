package com.findeat.apirest.models.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.findeat.apirest.dto.web.EditPlateDTO;
import com.findeat.apirest.models.entity.Menu;
import com.findeat.apirest.models.entity.Plate;

public interface IPlateService {

	public Plate create(Plate plate);

	public List<Plate> getPlates(Menu menu);

	public ResponseEntity<?> editPlate(EditPlateDTO editPlateDTO);

}
