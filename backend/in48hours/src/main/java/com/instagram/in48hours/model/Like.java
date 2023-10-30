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
@Entity(name = "like")
public class Like {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	private Timestamp timestamp;
}
