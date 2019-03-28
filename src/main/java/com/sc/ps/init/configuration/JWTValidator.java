package com.sc.ps.init.configuration;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JWTValidator {
	private String secret = "EPAMINDIA";

	public JWTUser validate(String token) {
		JWTUser user = null;
		try {
			Claims body = Jwts.parser()
					.setSigningKey(secret)
					.parseClaimsJws(token)
					.getBody();

			user = new JWTUser();

			user.setUsername(body.getSubject());
			user.setId(Long.parseLong(body.getId()));
			user.setRole((String) body.get("role"));
		} catch (Exception e) {
			System.err.println(e);
		}
		return user;
	}

}
