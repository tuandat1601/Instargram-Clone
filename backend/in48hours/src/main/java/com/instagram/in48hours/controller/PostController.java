package com.instagram.in48hours.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instagram.in48hours.entities.Post;
import com.instagram.in48hours.repository.PostRepository;
import com.instagram.in48hours.service.post.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
	
	@Autowired
	PostService postService;
 @GetMapping("/posts")
 public ResponseEntity<List<Post>> getListPost(){
	 
	 return ResponseEntity.ok(postService.getListPost());
 }
}
