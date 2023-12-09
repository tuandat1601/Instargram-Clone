package com.instagram.in48hours.service.impl.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.instagram.in48hours.dto.UpdateUserRequest;
import com.instagram.in48hours.entities.Post;
import com.instagram.in48hours.entities.Users;
import com.instagram.in48hours.repository.UserRepository;
import com.instagram.in48hours.service.user.UserService;

import lombok.RequiredArgsConstructor;

@Service
public class UserServiceIml implements UserService {
	
	@Autowired
    private UserRepository userRepository; 
	
	@Override
	public UserDetailsService userDetailsService() {
		// TODO Auto-generated method stub
		return new UserDetailsService() {
			
			@Override
			public UserDetails loadUserByUsername(String username)  {
				// TODO Auto-generated method stub
//				System.out.println(username );
				return userRepository.findByUserName(username)
						.orElseThrow(()-> new UsernameNotFoundException("User not found"));
			}
		};
	}

	@Override
	public Users updateUser(UpdateUserRequest updateUserRequest) {
		Optional<Users>  optionalUser =userRepository.findByUserName(updateUserRequest.getUserName());
		Users existingUser =  optionalUser.get();
		if (optionalUser.isPresent()) {
			if(!updateUserRequest.getBio().isEmpty()) {
				existingUser.setBio(updateUserRequest.getBio());
			}
			if(!updateUserRequest.getEmail().isEmpty()) {
				existingUser.setEmail(updateUserRequest.getEmail());
			}
			if(!updateUserRequest.getGender().isEmpty()) {
				existingUser.setGender(updateUserRequest.getGender());
			}
		}
		return userRepository.save(existingUser);
	} ;
	
}
