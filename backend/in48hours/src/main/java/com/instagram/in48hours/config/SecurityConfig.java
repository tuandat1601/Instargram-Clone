package com.instagram.in48hours.config;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
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

import com.instagram.in48hours.service.UserService;
import com.instagram.in48hours.service.impl.UserServiceIml;

import lombok.RequiredArgsConstructor;
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {
	@Autowired
	private JWTAuthenticationFilter authenticationFilter;
	
	 @Bean
	    public UserDetailsService userDetailsService() { 
	        return new UserServiceIml(); 
	    } 
	 private static final String[] WHITE_LIST_URL = {
		
			 "/api/v1/welcome/**"
			
	 };
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
         authenticationProvider.setUserDetailsService(userDetailsService()); 
         authenticationProvider.setPasswordEncoder(passwordEncoder()); 
         return authenticationProvider; 
     } 
   
}
