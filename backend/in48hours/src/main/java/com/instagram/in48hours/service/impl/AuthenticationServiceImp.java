package com.instagram.in48hours.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.instagram.in48hours.dto.JwtAuthenticationResponse;
import com.instagram.in48hours.dto.SignInRequest;
import com.instagram.in48hours.dto.SignUpRequest;

import com.instagram.in48hours.entities.Role;
import com.instagram.in48hours.entities.Users;
import com.instagram.in48hours.repository.UserRepository;
import com.instagram.in48hours.service.AuthenticationService;
import com.instagram.in48hours.service.JWTService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImp implements AuthenticationService{
 @Autowired
 private  UserRepository userRepository;
 @Autowired
 private PasswordEncoder passwordEncoder;
 @Autowired
 private JWTService jwtService;
 
@Autowired
 private AuthenticationManager authenticationManager ;
 
 public Users signup(SignUpRequest signUpRequest) {
	Users user = new Users();
	user.setUserName(signUpRequest.getUserName());
	user.setEmail(signUpRequest.getEmail());
	user.setRole(Role.USER);
	user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
	user.setDeleted(false);
	return userRepository.save(user);
}
 public JwtAuthenticationResponse signin(SignInRequest signInRequest) {
	authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getUserName(),
			signInRequest.getPassword()));
	
    
	var user = userRepository.
				findByUserName(signInRequest.getUserName()).orElseThrow(()-> new UsernameNotFoundException("User not found"));
	 
	var jwt = jwtService.generateToken(user);
	var refreshtoken = jwtService.generateRefresnToken(new HashMap<>(), user);
	JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
	jwtAuthenticationResponse.setToken(jwt);
	jwtAuthenticationResponse.setRefreshToken(refreshtoken);
	return jwtAuthenticationResponse;
 }
}
