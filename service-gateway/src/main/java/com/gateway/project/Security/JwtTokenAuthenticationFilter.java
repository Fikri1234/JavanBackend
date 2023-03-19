/**
 * 
 */
package com.gateway.project.Security;

/**
 * @author user on 2023-03-16 05:10:23.232
 *
 */
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.gateway.project.Entity.MParamEntity;
import com.gateway.project.Service.MParamService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtTokenAuthenticationFilter extends OncePerRequestFilter  {
    
	Logger log = LoggerFactory.getLogger(getClass());
	static final String AUTH_HEADER = "Authorization";
	static final String AUTH_PREFIX = "Bearer ";
	
	@Autowired
	private MParamService mParamService;
	
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
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		log.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		// 1. get the authentication header. Tokens are supposed to be passed in the authentication header
		Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            log.info("ke: {} val: {}",key,value);
        }
		String header = request.getHeader(AUTH_HEADER);
		
		log.info("headdd: {} uri: {}",header,request.getRequestURI());
		log.info("res: {} loc: {}",request.getRequestURL(),request.getLocalAddr());
		
		// 2. validate the header and check the prefix
		if(header == null || !header.startsWith(AUTH_PREFIX)) {
			chain.doFilter(request, response);  		// If not valid, go to the next filter.
			return;
		}
		
		// If there is no token provided and hence the user won't be authenticated. 
		// It's Ok. Maybe the user accessing a public path or asking for a token.
		
		// All secured paths that needs a token are already defined and secured in config class.
		// And If user tried to access without access token, then he won't be authenticated and an exception will be thrown.
		
		// 3. Get the token
		String token = header.replace(AUTH_PREFIX, "");
		log.info("tken:=={}",token);
		
		try {	// exceptions might be thrown in creating the claims if for example the token is expired
			
			// 4. Validate the token
//			Claims claims = Jwts.parser()
//					.setSigningKey(jwtConfig.getSecret().getBytes())
//					.parseClaimsJws(token)
//					.getBody();
			
			Claims claims = getAllClaimsFromToken(token);
			
			String username = claims.getSubject();
			if(username != null) {
				@SuppressWarnings("unchecked")
				List<String> authorities = (List<String>) claims.get("authorities");
				log.info("aut: {}",authorities);
				
				// 5. Create auth object
				// UsernamePasswordAuthenticationToken: A built-in object, used by spring to represent the current authenticated / being authenticated user.
				// It needs a list of authorities, which has type of GrantedAuthority interface, where SimpleGrantedAuthority is an implementation of that interface
				 UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
								 username, null, authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
				 
				 // 6. Authenticate the user
				 // Now, user is authenticated
				 SecurityContextHolder.getContext().setAuthentication(auth);
			}
			
		} catch (Exception e) {
			// In case of failure. Make sure it's clear; so guarantee user won't be authenticated
			SecurityContextHolder.clearContext();
			e.printStackTrace();
			log.info("excc: {}",e.getMessage());
		}
		
		// go to the next filter in the filter chain
		chain.doFilter(request, response);
	}
	
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(getSecret()).parseClaimsJws(token).getBody();
	}

}
