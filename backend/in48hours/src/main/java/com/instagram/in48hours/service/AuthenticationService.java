package com.instagram.in48hours.service;

import com.instagram.in48hours.dto.JwtAuthenticationResponse;
import com.instagram.in48hours.dto.SignInRequest;
import com.instagram.in48hours.dto.SignUpRequest;
import com.instagram.in48hours.entities.Users;

public interface AuthenticationService {
	Users signup(SignUpRequest signUpRequest);
	JwtAuthenticationResponse signin(SignInRequest signInRequest) ;
}
