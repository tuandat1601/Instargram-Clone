package com.instagram.in48hours.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.instagram.in48hours.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	   Optional<User> findByName(String username); 
}
