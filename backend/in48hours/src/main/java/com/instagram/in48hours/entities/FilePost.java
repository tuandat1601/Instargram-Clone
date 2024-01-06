package com.instagram.in48hours.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity(name = "filepost")


public class FilePost {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String name;
private String type;
private String path;

@ManyToOne
@JoinColumn(name = "post_id")
private Post post;

public FilePost(Long id, String name, String type, String path, Post post) {
	super();
	this.id = id;
	this.name = name;
	this.type = type;
	this.path = path;
	this.post = post;
}

public FilePost() {
	super();
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getPath() {
	return path;
}

public void setPath(String path) {
	this.path = path;
}

public Post getPost() {
	return post;
}

public void setPost(Post post) {
	this.post = post;
}


}
