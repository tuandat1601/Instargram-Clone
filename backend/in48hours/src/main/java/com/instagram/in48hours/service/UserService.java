package com.instagram.in48hours.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
	UserDetails loadUserByUsername(String username) ;
}
