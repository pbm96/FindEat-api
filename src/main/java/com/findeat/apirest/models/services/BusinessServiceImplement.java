package com.findeat.apirest.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findeat.apirest.models.dao.IBusinessDAO;
import com.findeat.apirest.models.entity.Business;

@Service
public class BusinessServiceImplement implements IBusinessService {

	@Autowired
	IBusinessDAO businessDao;

	@Override
	public Business findByUuid(String uuid) {

		return businessDao.findByUuid(uuid);
	}

}
