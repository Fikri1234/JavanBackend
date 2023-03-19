/**
 * 
 */
package com.gateway.project.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.gateway.project.Security.JwtAuthenticationEntryPoint;
import com.gateway.project.Security.JwtTokenAuthenticationFilter;
import com.gateway.project.ServiceImpl.CustomUserDetailServiceImpl;

@Configuration
@EnableWebSecurity
@Import(Encoder.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
static final String AUTH_URI = "/auth/**";
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Autowired
	@Qualifier("customAuthenticationProvider")
	AuthenticationProvider authenticationProvider;
	
	@Autowired
	private CustomUserDetailServiceImpl customUserDetailServiceImpl;
	
    @Autowired
    private PasswordEncoder userPasswordEncoder;
	 
	@Bean
    public JwtTokenAuthenticationFilter authenticationJwtTokenFilter() {
      return new JwtTokenAuthenticationFilter();
    }
	
	@Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(this.customUserDetailServiceImpl)
                .passwordEncoder(userPasswordEncoder);
    }
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // we don't need CSRF because our token is invulnerable
        .csrf()
        .disable()
        .authorizeRequests()
		.antMatchers(HttpMethod.POST, AUTH_URI).permitAll()
//		.antMatchers("/**").permitAll()
//		.antMatchers("/user/**").hasAnyRole("ADMIN") // All three users should be able to get all products.
//		.antMatchers("/user/**").permitAll()
//		.antMatchers("/user/**").access("hasAnyAuthority('USER')")
		.antMatchers("/user/**").hasAuthority("ADMIN")
		.antMatchers("/pajak/checker-for/maker").hasAuthority("CHECKER")
		.antMatchers("/pajak/approver-for/checker").hasAuthority("APPROVER")
		.antMatchers("/pajak/maker").hasAuthority("MAKER")
		.antMatchers("/pajak/checker").hasAuthority("CHECKER")
		// all other requests need to be authenticated
				.anyRequest().authenticated().and().
		// make sure we use stateless session; session won't be used to
		// store user's state.
				exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
        httpSecurity.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
