package com.findeat.apirest.dto.web;

import java.io.Serializable;

public class EditPlateDTO implements Serializable {

	private Long idPlate;
	private String name;
	private Double price;
	private String image;
	private Long idMenu;

	public Long getIdPlate() {
		return idPlate;
	}

	public void setIdPlate(Long idPlate) {
		this.idPlate = idPlate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Long idMenu) {
		this.idMenu = idMenu;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -6305518801690004496L;

}
