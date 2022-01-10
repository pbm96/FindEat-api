package com.findeat.apirest.dto.web;

import java.io.Serializable;

public class AutocompletePlacesDTO implements Serializable {

	private String search;

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	private static final long serialVersionUID = -6738508823979984797L;

}
