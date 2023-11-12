package com.instagram.in48hours.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.instagram.in48hours.model.User;
import com.instagram.in48hours.repository.UserRepository;
import com.instagram.in48hours.service.UserService;

@Component
public class UserServiceIml implements UserService {
	
	@Autowired
    private UserRepository userRepository; 
	 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
		  
	      return  userRepository.findByName(username)
	        .orElseThrow(() -> new UsernameNotFoundException("User not found " + username)); 
	    } ;
}
