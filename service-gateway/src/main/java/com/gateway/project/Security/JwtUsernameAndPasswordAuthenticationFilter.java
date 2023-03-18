package com.gateway.project.Security;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gateway.project.DTO.JwtAuthReqDTO;
import com.gateway.project.Entity.MParamEntity;
import com.gateway.project.Service.MParamService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUsernameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter   {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	static final String AUTH_HEADER = "Authorization";
	static final String AUTH_URI = "/auth/**";
	
	// We use auth manager to validate the user credentials
	private AuthenticationManager authManager;
	private MParamService mParamService;
    
	public JwtUsernameAndPasswordAuthenticationFilter(AuthenticationManager authManager, MParamService mParamService) {
		this.authManager = authManager;
		this.mParamService = mParamService;
		
		// By default, UsernamePasswordAuthenticationFilter listens to "/login" path. 
		// In our case, we use "/auth". So, we need to override the defaults.
		this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(AUTH_URI, "POST"));
	}
	
	public int getExpiredIn() {
    	Optional<MParamEntity> exp = mParamService.findByParamName("JWT_EXPIRES");
    	int expires = Integer.parseInt(exp.get().getParamValue());
        return  expires;
    }

    public String getSecret() {
    	Optional<MParamEntity> str = mParamService.findByParamName("JWT_KEY");
        String secret = str.get().getParamValue();
        return  secret;
    }
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		try {
			
			// 1. Get credentials from request
			JwtAuthReqDTO creds = new ObjectMapper().readValue(request.getInputStream(), JwtAuthReqDTO.class);
			
			// 2. Create auth object (contains credentials) which will be used by auth manager
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
					creds.getUsername(), creds.getPassword(), Collections.emptyList());
			
			// 3. Authentication manager authenticate the user, and use UserDetialsServiceImpl::loadUserByUsername() method to load the user.
			return authManager.authenticate(authToken);
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	// Upon successful authentication, generate a token.
	// The 'auth' passed to successfulAuthentication() is the current authenticated user.
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		System.out.println("timeloggg: "+getExpiredIn());
		
		Long now = System.currentTimeMillis();
		String token = Jwts.builder()
			.setSubject(auth.getName())	
			// Convert to list of strings. 
			// This is important because it affects the way we get them back in the Gateway.
			.claim("authorities", auth.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
			.setIssuedAt(new Date(now))
			.setExpiration(new Date(now + getExpiredIn() * 1000))  // in milliseconds
			.signWith(SignatureAlgorithm.HS512, getSecret() .getBytes())
			.compact();
		
		log.info("tokeenn: {} {} {}",AUTH_HEADER, AUTH_URI, token);
		
		// Add token to header
		response.addHeader(AUTH_HEADER, AUTH_URI + token);
		response.addHeader("Auth-Header", AUTH_URI + token);
	}
}
