package com.instagram.in48hours.controller;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.instagram.in48hours.dto.PostRequest;
import com.instagram.in48hours.dto.PostWithFile;
import com.instagram.in48hours.entities.FilePost;
import com.instagram.in48hours.entities.Post;
import com.instagram.in48hours.repository.PostRepository;
import com.instagram.in48hours.repository.UserRepository;
import com.instagram.in48hours.service.filePost.FilePostService;
import com.instagram.in48hours.service.post.PostService;
import com.instagram.in48hours.util.EntityConverter;
import com.instagram.in48hours.util.Predicates;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;


import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

@RestController
@RequestMapping("/api/v1/post")
@Tag(name = "Posts")
@CrossOrigin( origins = "*")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	FilePostService filePostService;
 @GetMapping("/posts")
 public ResponseEntity<List<Post>> getListPost(){
	 
	 return ResponseEntity.ok(postService.getAll(postRepository));
 }
 @PostMapping("/posts")
 public ResponseEntity<Post> createPost(@ModelAttribute PostWithFile postWithFile ){
	 MultipartFile[]listfile = postWithFile.getFile();
	 Post post = new Post();
	 PostRequest postRequest = new PostRequest(postWithFile.getCaption(),postWithFile.getUser());
	 post = EntityConverter.convertToEntity(postRequest, Post.class);
	 post.setUser(userRepository.findById(postRequest.getUser()).orElse(null));
	 return ResponseEntity.ok(postService.create(postRepository, post, listfile));
	
	

	
 }
 
 @PostMapping("/file")
 public ResponseEntity<?> postfile(@RequestParam("file") MultipartFile tito ){
	 System.out.println(tito.getOriginalFilename());
//	 FilePost filePost = new FilePost();
//	 filePost.setName(postRequest.getFile().getName());
	
	 

	 return ResponseEntity.ok(tito);
 }
 @GetMapping("/files/{filename:.+}")

 public ResponseEntity<?> loadFile(@PathVariable String filename){
 	
 	Resource resource= filePostService.loadFile(filename);
 	
 			 return ResponseEntity.ok()
 				        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"").contentType(MediaType.valueOf("image/jpeg")).body(resource);
 }
}
