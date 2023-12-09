package com.instagram.in48hours.service.impl.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagram.in48hours.entities.Users;
import com.instagram.in48hours.repository.UserRepository;
import com.instagram.in48hours.service.user.AdminService;
@Service
public class AdminServiceImp implements AdminService{
	@Autowired
	UserRepository userRepository;

	@Override
	public String deleteUserByUserName(String username) {
		Optional<Users>  optionalUser =userRepository.findByUserName(username);
		if (optionalUser.isPresent()) {
			Users existingUser =  optionalUser.get();
			existingUser.setDeleted(true);;
		}
		return "Delete User successfully";
	}
	
	

}
	

	
