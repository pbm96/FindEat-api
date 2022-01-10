package com.findeat.apirest.models.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.findeat.apirest.dto.web.AutocompletePlacesDTO;
import com.findeat.apirest.models.dao.IBusinessDAO;
import com.findeat.apirest.models.dao.IUserDAO;
import com.findeat.apirest.models.entity.Business;
import com.findeat.apirest.models.entity.User;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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

	@Override
	public Business findByUuid(String uuid) {
		return businessDao.findByUuid(uuid);
	}

	@Override
	public ResponseEntity<?> findPlaces(AutocompletePlacesDTO autocompletePlacesDTO) {
		Map<String, Object> response = new HashMap<>();

		OkHttpClient client = new OkHttpClient().newBuilder().build();
		Request request = new Request.Builder()
				.url("https://maps.googleapis.com/maps/api/place/queryautocomplete/json?input="
						+ autocompletePlacesDTO.getSearch() + "&key=AIzaSyDSZG0ho-NCHo-Dkw7QaY9D2ke44xfxwCs")
				.method("GET", null).build();
		try {

			Response responsePlaces = client.newCall(request).execute();
			String jsonData = responsePlaces.body().string().toString();
			JSONObject jsonObject = new JSONObject(jsonData);

			response.put("messageResponse", jsonObject.toMap());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} catch (IOException e) {

			response.put("messageResponse", "No se han encontrado lugares");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
