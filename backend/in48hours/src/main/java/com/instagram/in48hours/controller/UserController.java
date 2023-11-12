package com.instagram.in48hours.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.instagram.in48hours.model.User;
import com.instagram.in48hours.service.impl.UserServiceIml;
@RestController
public class UserController {
	private UserServiceIml userService;
	
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

//@GetMapping("/users")
//public List<User> retrieveAllUsers(){
//	return userService.findAll();
//}

}
