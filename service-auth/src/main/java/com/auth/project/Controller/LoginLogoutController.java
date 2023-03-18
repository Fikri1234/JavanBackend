package com.auth.project.Controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auth.project.DTO.JwtAuthReqDTO;
import com.auth.project.DTO.JwtAuthRespDTO;
import com.auth.project.Entity.MUserEntity;
import com.auth.project.Security.JwtTokenUtil;
import com.auth.project.Service.MUserService;
import com.auth.project.ServiceImpl.CustomUserDetailServiceImpl;
import com.auth.project.Util.CustomException;




@RestController
public class LoginLogoutController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	@Qualifier("messageSource")
	private MessageSource messageSource;

    @Lazy
    @Autowired
    private AuthenticationManager authenticationManager;
    
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private CustomUserDetailServiceImpl userDetailsService;
	
	@Autowired
	private MUserService mUserService;
    
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthReqDTO authenticationRequest) throws CustomException {
    	
    	logger.info("login :: ");

    	try {
			authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
	
			final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
	
			final String token = jwtTokenUtil.generateToken(userDetails);
			
			Optional<MUserEntity> optUser = mUserService.findByEmail(authenticationRequest.getUsername());
			long userId = 0;
			if (optUser.isPresent()) {
				userId = optUser.get().getId();
			}
			
			return ResponseEntity.ok(new JwtAuthRespDTO(token, Long.valueOf(jwtTokenUtil.getExpiredIn()), userId));
    	} catch (Exception e) {
			// TODO: handle exception
    		throw new CustomException(e.getMessage(), HttpStatus.FORBIDDEN);
		}
	}

	private void authenticate(String username, String password) throws Exception {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	}

}
