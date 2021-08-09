package com.teqto.certifyme.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teqto.certifyme.constant.SecurityConstants;
import com.teqto.certifyme.constant.ServiceConstants;
import com.teqto.certifyme.entity.AppsUser;
import com.teqto.certifyme.repository.AppsUserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private AppsUserRepository appsUserRepository;
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
	@RequestMapping(value = "/hallo", method = RequestMethod.GET)
	public String sayhi() {
		return "Hallo <h2> " + "User" + "</h1>";
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody AppsUser user) throws URISyntaxException {
		if (Objects.isNull(appsUserRepository.findByUsername(user.getUsername()))) {
			user.setUserrole(SecurityConstants.DEFAULT_USERROLE);
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			appsUserRepository.save(user);
			return ResponseEntity.created(new URI("/api/user/signup/" + user.getUsername())).body(user);
		}
		return ResponseEntity.unprocessableEntity().body(user.getUsername() + ServiceConstants.USEREXISTS);
	}
}
