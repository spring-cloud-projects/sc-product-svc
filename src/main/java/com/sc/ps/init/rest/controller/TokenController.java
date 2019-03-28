package com.sc.ps.init.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sc.ps.init.configuration.JWTTokenGenerator;
import com.sc.ps.init.configuration.JWTUser;

@RestController
public class TokenController {
	@Autowired
	private JWTTokenGenerator generator;
	
	@PostMapping("/generate")
	public String generatedToken(@RequestBody final JWTUser user) {
		return generator.generate(user);
	}
	
}
