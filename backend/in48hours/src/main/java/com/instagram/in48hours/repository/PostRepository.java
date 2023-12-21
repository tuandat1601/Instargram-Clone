package com.instagram.in48hours.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.instagram.in48hours.entities.Post;
import com.instagram.in48hours.entities.Users;

public interface PostRepository extends JpaRepository<Post, Long>{
	
}
