package com.findeat.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findeat.apirest.models.dao.IPlateDAO;
import com.findeat.apirest.models.entity.Menu;
import com.findeat.apirest.models.entity.Plate;

@Service
public class PlateServiceImplement implements IPlateService {
	@Autowired
	IPlateDAO iPlateDAO;

	@Override
	public Plate create(Plate plate) {

		return iPlateDAO.save(plate);
	}

	@Override
	public List<Plate> getPlates(Menu menu) {
		return iPlateDAO.findByMenu(menu);
	}

}
