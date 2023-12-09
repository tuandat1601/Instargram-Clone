package com.instagram.in48hours.service;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;

public interface JWTService {
	 String generateToken(UserDetails userDetails);
	  String generateRefresnToken(Map<String,Object> extraClams,UserDetails userDetails);	 
	    String extractUsername(String token);

	    Date extractExpiration(String token);

	    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);
	    Claims extractAllClaims(String token);
	    Boolean validateToken(String token, UserDetails userDetails);
	    Boolean isTokenExpired(String token); 
	  
}
