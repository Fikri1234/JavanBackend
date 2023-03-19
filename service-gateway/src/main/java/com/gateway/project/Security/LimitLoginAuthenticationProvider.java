package com.gateway.project.Security;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.gateway.project.Exception.BadCredentialExceptionHandler;
import com.gateway.project.Exception.LockedExceptionHandler;



@Component("customAuthenticationProvider")
public class LimitLoginAuthenticationProvider extends DaoAuthenticationProvider {

	private static final Logger logger = LoggerFactory.getLogger(LimitLoginAuthenticationProvider.class);
	
	@Autowired
	@Qualifier("customUserDetailService")
	@Override
	public void setUserDetailsService(UserDetailsService userDetailsService) {
		super.setUserDetailsService(userDetailsService);
	}
	
	@Override
	public Authentication authenticate(Authentication authentication) 
          throws AuthenticationException {

		try {
			Authentication auth = super.authenticate(authentication);
			logger.info("masuk limit: {}",authentication.getName());
				
			return auth;
		} catch (DisabledException e) {
			throw new DisabledException("user disabled", e.getCause());
		} catch (BadCredentialsException e) {
			logger.error("user/password wrong", e);
			//invalid login, update to user_attempts
			//throw e;
			throw new BadCredentialExceptionHandler("user/password wrong", e.getCause());
		} catch (LockedException e) {
			//this user is locked!
			logger.error("user "+authentication.getName()+" is locked", e);
			throw new LockedExceptionHandler("User has been locked! Please call Administrator.", e.getCause());
		} catch (AccountExpiredException ex) {
            // this user is expired
            throw ex;
        } 
		
	}
}
