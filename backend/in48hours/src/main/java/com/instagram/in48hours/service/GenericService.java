package com.instagram.in48hours.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.instagram.in48hours.entities.Post;

public interface GenericService {

	<T> List<T> getAll(JpaRepository<T, Long> repository) ;
	<T,U> T create(JpaRepository<T, Long> repository, T entity, U type);
   <T> Optional<T> getById(JpaRepository<T, Long> repository, Long id); 
  
   <T> T update(JpaRepository<T, Long> repository, T entity);
   <T> T partialUpdate(JpaRepository<T, Long> repository, Long id, Map<String, Object> updates) ;
   <T> void deleteById(JpaRepository<T, Long> repository, Long id) ;
}
