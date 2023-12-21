package com.instagram.in48hours.service.impl.post;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.instagram.in48hours.dto.PostRequest;
import com.instagram.in48hours.entities.Post;
import com.instagram.in48hours.repository.PostRepository;
import com.instagram.in48hours.service.GenericService;
import com.instagram.in48hours.service.post.PostService;

import jakarta.persistence.EntityExistsException;
@Service
public class PostServiceImp implements PostService {
@Autowired
PostRepository postRepository;
@Autowired
GenericService genericService;

public <T> List<T> getAll(JpaRepository<T, Long> repository) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public <T> T create(JpaRepository<T, Long> repository, T entity, Predicate<T> condition) {
	 if (condition!=null&&condition.test(entity)) {
         throw new EntityExistsException("Entity already exists with the given condition.");
     }

     // Save the new entity to the database
     return repository.save(entity);
}

public <T> Optional<T> getById(JpaRepository<T, Long> repository, Long id) {
	// TODO Auto-generated method stub
	return null;
}

public <T> T update(JpaRepository<T, Long> repository, T entity) {
	// TODO Auto-generated method stub
	return null;
}

public <T> T partialUpdate(JpaRepository<T, Long> repository, Long id, Map<String, Object> updates) {
	// TODO Auto-generated method stub
	return null;
}

public <T> void deleteById(JpaRepository<T, Long> repository, Long id) {
	// TODO Auto-generated method stub
	
}







	
	
}
