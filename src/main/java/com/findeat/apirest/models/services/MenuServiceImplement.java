package com.findeat.apirest.models.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.findeat.apirest.dto.web.CreateMenuDTO;
import com.findeat.apirest.dto.web.GetMenuBusinessDTO;
import com.findeat.apirest.dto.web.UuidDTO;
import com.findeat.apirest.models.dao.IBusinessDAO;
import com.findeat.apirest.models.dao.IMenuDAO;
import com.findeat.apirest.models.entity.Business;
import com.findeat.apirest.models.entity.Menu;
import com.findeat.apirest.models.entity.Plate;

@Service
public class MenuServiceImplement implements IMenuService {

	@Autowired
	IMenuDAO menuDao;
	@Autowired
	IBusinessDAO businessDAO;

	@Autowired
	IPlateService plateService;
	@Autowired
	IBusinessService businessService;

	@Autowired
	IMenuService menuService;

	@Override
	public ResponseEntity<?> create(CreateMenuDTO createMenuDto) {

		Map<String, Object> response = new HashMap<>();

		try {
			Business business = businessService.findByUuid(createMenuDto.getBusinessUuid());
			Menu menu = new Menu();
			Menu menuSave;
			menu.setName(createMenuDto.getName());
			menu.setBusiness(business);

			menuSave = menuDao.save(menu);
			business.setMenu(menuSave);

			businessDAO.save(business);
			if (menuSave != null) {
				for (Plate plate : createMenuDto.getPlates()) {
					plate.setMenu(menuSave);
					plateService.create(plate);
				}
				response.put("messsageResponse", "Menu creado correctamente");

			}

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

		} catch (DataAccessException e) {

			response.put("messsageResponse", "Error al crear menu");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> getMenu(UuidDTO uuid) {

		Map<String, Object> response = new HashMap<>();

		try {
			GetMenuBusinessDTO responseMenu = new GetMenuBusinessDTO();
			Business business = businessService.findByUuid(uuid.getUuid());

			Menu menu = menuDao.findByBusiness(business);
			menu.setBusiness(null);

			List<Plate> plates = plateService.getPlates(menu);
			responseMenu.setMenu(menu);
			responseMenu.setPlates(plates);
			response.put("data", responseMenu);

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

		} catch (DataAccessException e) {

			response.put("messsageResponse", "Error al crear menu");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
