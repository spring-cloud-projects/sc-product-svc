package com.sc.ps.init.configuration;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class JWTAuthenticationToken extends UsernamePasswordAuthenticationToken {

	private static final long serialVersionUID = -7523884749268326273L;

	private String token;

	public JWTAuthenticationToken(String token) {
		super(null, null);
		this.token = token;
	}

	@Override
	public Object getPrincipal() {
		return null;
	}

	@Override
	public Object getCredentials() {
		return null;
	}

	public String getToken() {
		return token;
	}

}
