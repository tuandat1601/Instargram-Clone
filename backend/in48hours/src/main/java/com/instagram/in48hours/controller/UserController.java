package com.instagram.in48hours.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.instagram.in48hours.model.User;
import com.instagram.in48hours.service.UserService;
@RestController
public class UserController {
	private UserService userService;
	
 public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

@RequestMapping(method = RequestMethod.GET,path = "/hello")
 public String Hello() {
	 return "Hello Đạt";
 }
@GetMapping("/users")
public List<User> retrieveAllUsers(){
	return userService.findAll();
}

}
