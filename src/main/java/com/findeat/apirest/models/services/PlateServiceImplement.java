package com.findeat.apirest.models.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.findeat.apirest.dto.web.EditPlateDTO;
import com.findeat.apirest.models.dao.IPlateDAO;
import com.findeat.apirest.models.entity.Menu;
import com.findeat.apirest.models.entity.Plate;

@Service
public class PlateServiceImplement implements IPlateService {
	@Autowired
	IPlateDAO iPlateDAO;

	@Autowired
	IMenuService menuService;

	@Override
	public Plate create(Plate plate) {

		return iPlateDAO.save(plate);
	}

	@Override
	public List<Plate> getPlates(Menu menu) {
		return iPlateDAO.findByMenu(menu);
	}

	@Override
	public ResponseEntity<?> editPlate(EditPlateDTO editPlateDTO) {
		Map<String, Object> response = new HashMap<>();

		try {
			Plate plate = new Plate();
			plate.setId(editPlateDTO.getIdPlate());
			plate.setImage(editPlateDTO.getImage());
			plate.setName(editPlateDTO.getName());
			plate.setPrice(editPlateDTO.getPrice());
			plate.setMenu(menuService.getMenuById(editPlateDTO.getIdMenu()));
			if (plate.getMenu() != null) {
				iPlateDAO.save(plate);
				response.put("messsageResponse", "Plato actualizado correctamente");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

			}
			response.put("messsageResponse", "Error al modificar plato");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (DataAccessException e) {

			response.put("messsageResponse", "Error al modificar plato");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
