package com.findeat.apirest.dto.web;

import java.io.Serializable;
import java.util.List;

import com.findeat.apirest.models.entity.Menu;
import com.findeat.apirest.models.entity.Plate;

public class GetMenuBusinessDTO implements Serializable {

	private Menu menu;
	private List<Plate> plates;

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<Plate> getPlates() {
		return plates;
	}

	public void setPlates(List<Plate> plates) {
		this.plates = plates;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5076432371778528684L;
}
