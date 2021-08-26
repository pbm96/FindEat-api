package com.findeat.apirest.models.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.findeat.apirest.models.dao.IUserDAO;
import com.findeat.apirest.models.entity.User;

@Service
public class UserService implements UserDetailsService{
	
	private Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private IUserDAO userDao;
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userDao.findByUsername(username);
		
		if(user == null) {
			logger.error("No existe el usuario en el sistema"+username);
			throw new UsernameNotFoundException("No existe el usuario en el sistema"+username);
		}
		
		 List<GrantedAuthority> authorities = new ArrayList<>();
		 authorities.add(new SimpleGrantedAuthority(user.getRole().getRole()));		
		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}

}
