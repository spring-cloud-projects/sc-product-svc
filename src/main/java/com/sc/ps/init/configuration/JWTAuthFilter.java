package com.sc.ps.init.configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class JWTAuthFilter extends AbstractAuthenticationProcessingFilter {

	public JWTAuthFilter() {
		super("/prodsvc/**");
	}

	@Override
	@Autowired
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		super.setAuthenticationManager(authenticationManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {

		String tokenHeader = request.getHeader("JWT-Token");

		if (tokenHeader == null || !tokenHeader.startsWith("TOKEN")) {
			throw new RuntimeException("Token is invalid!!");
		}

		String authToken = tokenHeader.substring(5);

		JWTAuthenticationToken token = new JWTAuthenticationToken(authToken);

		return token;
	}

	@Override
	public void setAuthenticationSuccessHandler(AuthenticationSuccessHandler successHandler) {
		super.setAuthenticationSuccessHandler(getSuccessHandler());
	}

	public AuthenticationSuccessHandler getSuccessHandler() {
		return (request, response, authentication) -> {
			// success implementation goes here
			System.out.println("Successfully Authenticated");
		};
	}

	public AuthenticationFailureHandler getFailureHandler() {
		return (request, response, authentication) -> {
			// failure implementation goes here
		};
	}

	@Override
	public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		chain.doFilter(request, response);
	}
}
