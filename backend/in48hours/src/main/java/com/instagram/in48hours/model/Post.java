package com.instagram.in48hours.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "post")
public class Post {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	private String caption;
private String image;
	
	private int comments;

	private int likes;
	private Timestamp timestamp;
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
