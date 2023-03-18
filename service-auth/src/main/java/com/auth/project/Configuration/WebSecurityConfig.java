package com.auth.project.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import com.auth.project.Security.JwtAuthenticationEntryPoint;
import com.auth.project.Security.JwtRequestFilter;
import com.auth.project.ServiceImpl.CustomUserDetailServiceImpl;

@EnableWebSecurity
@Import(Encoder.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	static final String AUTH_URI = "/**";
	
	@Autowired
	@Qualifier("customAuthenticationProvider")
	AuthenticationProvider authenticationProvider;
	
	@Autowired
	private CustomUserDetailServiceImpl customUserDetailServiceImpl;
	
    @Autowired
    private PasswordEncoder userPasswordEncoder;
     
    @Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    
    @Bean
    public JwtRequestFilter authenticationJwtTokenFilter() {
      return new JwtRequestFilter();
    }
    
    @Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
    
    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(this.customUserDetailServiceImpl)
                .passwordEncoder(userPasswordEncoder);
    }
    
    @Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // we don't need CSRF because our token is invulnerable
        .csrf()
        .disable()
        .authorizeRequests()
		.antMatchers(HttpMethod.POST, AUTH_URI).permitAll()
		.antMatchers("/user/**").hasAuthority("USER")
		// all other requests need to be authenticated
				.anyRequest().authenticated().and().
		// make sure we use stateless session; session won't be used to
		// store user's state.
				exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
	
	@Bean
    public DefaultAuthenticationEventPublisher authenticationEventPublisher() {
        return new DefaultAuthenticationEventPublisher();
    }

	/**
     * This is essential to make sure that the Spring Security session registry 
     * is notified when the session is destroyed.
     * @return
     */
    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }
    @Bean
    public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher1() {
      return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
    }
}
