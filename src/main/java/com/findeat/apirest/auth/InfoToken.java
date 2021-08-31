package com.findeat.apirest.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.findeat.apirest.models.entity.User;
import com.findeat.apirest.models.services.IUserService;

@Component
public class InfoToken implements TokenEnhancer{

	@Autowired
	private IUserService userService;
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		User user = userService.findByUsername(authentication.getName());
		Map<String, Object> info = new HashMap<>();
		
		info.put("userName", user.getUsername());
		info.put("adress", user.getAdress());
		info.put("email", user.getEmail());
		info.put("latitude", user.getLatitude());
		info.put("longitude", user.getLongitude());
		info.put("name", user.getName());
		info.put("phone", user.getPhone());
		info.put("uuid", user.getUuid());


		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}
	
	

}
