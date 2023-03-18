package com.auth.project.ServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth.project.DTO.MUserDTO;
import com.auth.project.Entity.MUserEntity;
import com.auth.project.Service.MUserService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service("customUserDetailService")
public class CustomUserDetailServiceImpl implements UserDetailsService {
	
	private MUserService mUserService;
	private PasswordEncoder userPasswordEncoder;
	
	public CustomUserDetailServiceImpl(MUserService mUserService, PasswordEncoder userPasswordEncoder) {
		super();
		this.mUserService = mUserService;
		this.userPasswordEncoder = userPasswordEncoder;
	}

	
	@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
		log.info("[CustomUserDetailService] loadUserByUsername username: {}",email);
		Optional<MUserEntity> mUserEntity = mUserService.findByEmail(email);
        
        if (mUserEntity.isPresent()) {    	
        		
        	List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(mUserEntity.get().getRole().getCode()));
    		log.info("auth: {}",authorities.toString());
    		
    		MUserDTO dto = new MUserDTO();
    		BeanUtils.copyProperties(mUserEntity.get(), dto);
        	return new User (dto.getEmail(), dto.getPassword(), authorities);
		}else {
			log.error("userId not found: ",email);
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", email));
		}
	}
	
	public boolean validatePassword(String email, String password) {
		Optional<MUserEntity> account = mUserService.findByEmail(email);
		if(account.isPresent()){
			// Verify the encoded password obtained from storage matches the submitted raw password 
			// after it too is encoded. Returns true if the passwords match, false if they do not. 
			// The stored password itself is never decoded.
			return userPasswordEncoder.matches(password, account.get().getPassword());
		}
		return false;
	}

}
