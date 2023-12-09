package com.instagram.in48hours.service.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.instagram.in48hours.dto.UpdateUserRequest;
import com.instagram.in48hours.entities.Users;

public interface UserService {
	UserDetailsService userDetailsService() ;
	Users updateUser(UpdateUserRequest updateUserRequest);
}
