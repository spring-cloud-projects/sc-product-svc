package com.sc.ps.init.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

public class JWTAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
	@Autowired
	private JWTValidator validator;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		return null;
	}

	@Override
	public boolean supports(Class<?> authenticationClass) {
		return JWTAuthenticationToken.class.isAssignableFrom(authenticationClass);
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// TODO Auto-generated method stub

	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authenticationToken)
			throws AuthenticationException {
		JWTAuthenticationToken jwtToken = (JWTAuthenticationToken) authenticationToken;
		String token = jwtToken.getToken();
		
		JWTUser user = validator.validate(token);
		
		if(user == null) {
			throw new RuntimeException("Invalid Authentication Token!!!");
		}
		
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole());
		UserDetails ud = new JWTUserDetails(user.getUsername(), user.getId(), token, grantedAuthorities);
		return ud;
	}
}
