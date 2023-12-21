package com.instagram.in48hours.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.instagram.in48hours.entities.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
	Optional <Users> findByUserName(String username); 
	   Optional<Users> findByEmail(String email); 
	   Optional<Users> findById(long id);
}
