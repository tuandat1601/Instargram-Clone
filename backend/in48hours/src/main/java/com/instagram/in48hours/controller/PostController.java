package com.instagram.in48hours.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instagram.in48hours.dto.PostRequest;
import com.instagram.in48hours.entities.Post;
import com.instagram.in48hours.repository.PostRepository;
import com.instagram.in48hours.repository.UserRepository;
import com.instagram.in48hours.service.post.PostService;
import com.instagram.in48hours.util.EntityConverter;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.function.Predicate;

@RestController
@RequestMapping("/api/v1/post")
@Tag(name = "Posts")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	UserRepository userRepository;
 @GetMapping("/posts")
 public ResponseEntity<List<Post>> getListPost(){
	 
	 return ResponseEntity.ok(postService.getAll(postRepository));
 }
 @PostMapping("/posts")
 public ResponseEntity<Post> createPost(@RequestBody PostRequest postRequest){
	 Post post = EntityConverter.convertToEntity(postRequest, Post.class);
	 post.setUser(userRepository.findById(postRequest.getUser()).orElse(null));

	 return ResponseEntity.ok(postService.create(postRepository, post, null));
 }
}
