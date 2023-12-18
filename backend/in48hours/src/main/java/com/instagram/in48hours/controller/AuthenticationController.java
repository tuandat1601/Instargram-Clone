package com.instagram.in48hours.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instagram.in48hours.dto.JwtAuthenticationResponse;
import com.instagram.in48hours.dto.SignInRequest;
import com.instagram.in48hours.dto.SignUpRequest;
import com.instagram.in48hours.entities.Users;
import com.instagram.in48hours.service.AuthenticationService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin( origins = "*")
@Tag(name = "Authentication")
public class AuthenticationController {
	@Autowired
private AuthenticationService authenticationService;
	
	@PostMapping("/signup")
	public ResponseEntity<Users> signup(@RequestBody SignUpRequest signUpRequest){
		return ResponseEntity.ok(authenticationService.signup(signUpRequest));
	}
	@PostMapping("/signin")
	public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignInRequest signInRequest){
		return ResponseEntity.ok(authenticationService.signin(signInRequest));
	}
}
