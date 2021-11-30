package com.findeat.apirest.models.services;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.findeat.apirest.controllers.GenericController;
import com.findeat.apirest.models.dao.IUserDAO;
import com.findeat.apirest.models.entity.User;

@Service
public class UserServiceImplement implements IUserService, UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(UserServiceImplement.class);
	@Autowired
	private IUserDAO userDao;

	@Autowired
	private GenericController genericController;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userDao.findByUsername(username);

		if (user == null) {
			logger.error("No existe el usuario en el sistema" + username);
			throw new UsernameNotFoundException("No existe el usuario en el sistema" + username);
		}

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getRole().getRole()));
		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), user.isEnabled(),
				true, true, true, authorities);
	}

	@Override
	public User findByUsername(String username) {

		return userDao.findByUsername(username);
	}

	@Override
	public ResponseEntity<?> RegisterUser(User user) {
		int strength = 10;
		User userRegistered = null;
		Map<String, Object> response = new HashMap<>();
		try {
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
			String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);

			user.setCreatedAt(new Date());
			user.setEnabled(true);
			user.setRole(genericController.getRoleUser());

			userRegistered = userDao.save(user);
			if (userRegistered != null)
				response.put("response", "Usuario registrado correctamente");

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

		} catch (DataAccessException e) {

			response.put("response", "Error al registrar nuevo usuario");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
