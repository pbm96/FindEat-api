package com.findeat.apirest.models.services;

import com.findeat.apirest.models.entity.Business;

public interface IBusinessService {

	public Business findByUser(String uuid);
}
