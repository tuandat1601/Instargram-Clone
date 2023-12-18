package com.instagram.in48hours.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.instagram.in48hours.dto.UpdateUserRequest;
import com.instagram.in48hours.entities.Users;
import com.instagram.in48hours.service.impl.user.UserServiceIml;
import com.instagram.in48hours.service.user.UserService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api/v1/user")
@SecurityRequirement(name="bearerAuth")
@CrossOrigin( origins = "*")
@Tag(name = "User")
public class UserController {
	private UserService userService;
	
 public UserController(UserServiceIml userService) {
		super();
		this.userService = userService;
	}
 @GetMapping("/hello")
 public String Hello() {
	 return "Hello Đạt";
 }
 @GetMapping("/con")
 public String Con() {
	 return "Cặc";
 }
 @GetMapping("/lon")
 public String Lon() {
	 return "Lon";
 }
@PatchMapping("/update")
 public ResponseEntity<Users> updateUser(@RequestBody UpdateUserRequest updateUserRequest){
	return ResponseEntity.ok(userService.updateUser(updateUserRequest));
}
//@GetMapping("/users")
//public List<User> retrieveAllUsers(){
//	return userService.findAll();
//}

}
