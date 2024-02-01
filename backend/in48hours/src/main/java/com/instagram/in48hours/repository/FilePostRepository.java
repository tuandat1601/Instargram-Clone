package com.instagram.in48hours.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.instagram.in48hours.entities.FilePost;

public interface FilePostRepository extends JpaRepository<FilePost, Long>{
	Optional<FilePost> findByName(String filename);
}
