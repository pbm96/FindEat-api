package com.findeat.apirest.dto.web;

import java.io.Serializable;
import java.util.List;

import com.findeat.apirest.models.entity.Plate;

public class CreateMenuDTO implements Serializable {

	String name;
	String businessUuid;
	List<Plate> plates;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBusinessUuid() {
		return businessUuid;
	}

	public void setBusinessUuid(String businessUuid) {
		this.businessUuid = businessUuid;
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
	private static final long serialVersionUID = -5416577177364666109L;

}
