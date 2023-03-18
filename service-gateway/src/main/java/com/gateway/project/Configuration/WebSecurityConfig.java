/**
 * 
 */
package com.gateway.project.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.gateway.project.Security.JwtAuthenticationEntryPoint;
import com.gateway.project.Security.JwtTokenAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
static final String AUTH_URI = "/auth/**";
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Bean
    public JwtTokenAuthenticationFilter authenticationJwtTokenFilter() {
      return new JwtTokenAuthenticationFilter();
    }
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // we don't need CSRF because our token is invulnerable
        .csrf()
        .disable()
        .authorizeRequests()
		.antMatchers(HttpMethod.POST, AUTH_URI).permitAll()
		.antMatchers("/**").permitAll()
//		.antMatchers("/user/**").permitAll()
//		.antMatchers("/user/**").access("hasAnyAuthority('USER')")
//		.antMatchers("/user/**").hasAuthority("USER")
		// all other requests need to be authenticated
				.anyRequest().authenticated().and().
		// make sure we use stateless session; session won't be used to
		// store user's state.
				exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
