package com.findeat.apirest.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findeat.apirest.models.dao.IBusinessDAO;
import com.findeat.apirest.models.dao.IUserDAO;
import com.findeat.apirest.models.entity.Business;
import com.findeat.apirest.models.entity.User;

@Service
public class BusinessServiceImplement implements IBusinessService {

	@Autowired
	IBusinessDAO businessDao;
	@Autowired
	IUserDAO userDAO;

	@Override
	public Business findByUser(String uuid) {

		User user = userDAO.findByUuid(uuid);
		return businessDao.findByUser(user);
	}

}
