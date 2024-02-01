package com.instagram.in48hours.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.instagram.in48hours.service.user.UserService;

import lombok.RequiredArgsConstructor;
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {
	@Autowired
	private JWTAuthenticationFilter authenticationFilter;
	
	
	 private static final String[] WHITE_LIST_URL = {
	
			 "/api/v1/welcome/**",
			 "/api/v1/auth/**",
			"/api/v1/post/**",
			
			 "/swagger-ui/**",
			 "/swagger-resources/**",
			 "/swagger-ui.html",
			 "/v3/api-docs/**",
"/hello/**"
			
	 };
	
	 
	 @Autowired
	 private UserService userService;
	 @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception { 
	        return config.getAuthenticationManager(); 
	    } 
	 
	 @Bean
	 public UserDetailsService userDetailsService(PasswordEncoder encoder) {
	        UserDetails admin = User.withUsername("hach")
	                .password(encoder.encode("hacheery"))
	                .roles("ADMIN")
	                .build();
	        UserDetails user = User.withUsername("user")
	                .password(encoder.encode("pwd1"))
	                .roles("USER")
	                .build();
	        return new InMemoryUserDetailsManager(admin, user);
	    }
     @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     
     @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	 http
    	 .csrf(AbstractHttpConfigurer::disable)
         .authorizeHttpRequests(req ->
         req.requestMatchers(WHITE_LIST_URL).permitAll()
         .requestMatchers("/api/v1/auth/admin/**").hasRole("ADMIN")
         .requestMatchers("/api/v1/auth/user/**").hasRole("USER")
         .anyRequest().authenticated())
         .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
         .authenticationProvider(authenticationProvider()) 
         .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class) ;
   
       return http.build();
        
     };
     @Bean
     public AuthenticationProvider authenticationProvider() { 
         DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(); 
         authenticationProvider.setUserDetailsService(userService.userDetailsService()); 
         authenticationProvider.setPasswordEncoder(passwordEncoder()); 
         return authenticationProvider; 
     } 
   
}
