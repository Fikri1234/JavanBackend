package com.auth.project.Exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author ATI-User
 * Jul 29, 2020
 */
public class AuthenticationExceptionHandler extends AuthenticationException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuthenticationExceptionHandler(String exception) {
		super(exception);
		System.out.println("exc: "+exception);
	}
	
	public AuthenticationExceptionHandler(String exception, Throwable cause) {
		super(exception, cause);
		System.out.println("exc: "+exception);
	}

}
