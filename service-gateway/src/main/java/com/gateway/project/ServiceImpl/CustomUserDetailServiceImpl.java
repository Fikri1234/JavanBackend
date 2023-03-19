package com.gateway.project.ServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gateway.project.Entity.MUserEntity;
import com.gateway.project.Repository.MUserRepository;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service("customUserDetailService")
public class CustomUserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	private MUserRepository mUserRepository;
	@Autowired
	private PasswordEncoder userPasswordEncoder;
	
	@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
		log.info("[CustomUserDetailService] loadUserByUsername username: {}",email);
		Optional<MUserEntity> mUserEntity = mUserRepository.findByEmail(email);
        
        if (mUserEntity.isPresent()) {    	
        		
        	List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(mUserEntity.get().getRole().getCode()));
    		log.info("auth: {}",authorities.toString());
    		
        	return new User (mUserEntity.get().getEmail(), mUserEntity.get().getPassword(), authorities);
		}else {
			log.error("userId not found: ",email);
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", email));
		}
	}
	
	public boolean validatePassword(String email, String password) {
		Optional<MUserEntity> account = mUserRepository.findByEmail(email);
		if(account.isPresent()){
			// Verify the encoded password obtained from storage matches the submitted raw password 
			// after it too is encoded. Returns true if the passwords match, false if they do not. 
			// The stored password itself is never decoded.
			return userPasswordEncoder.matches(password, account.get().getPassword());
		}
		return false;
	}

}
