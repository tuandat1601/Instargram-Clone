package com.instagram.in48hours.service.impl.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.instagram.in48hours.entities.Post;
import com.instagram.in48hours.repository.PostRepository;
import com.instagram.in48hours.service.post.PostService;
@Service
public class PostServiceImp implements PostService{
@Autowired
PostRepository postRepository;
	
	@Override
	public List<Post> getListPost() {
		
		return postRepository.findAll();
	}
	
	
}
