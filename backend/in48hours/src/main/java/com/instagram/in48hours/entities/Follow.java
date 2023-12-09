package com.instagram.in48hours.entities;

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

@Entity(name = "follow")
public class Follow {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	@ManyToOne
    @JoinColumn(name = "follower_id")
    private Users follower; // User who is following

    @ManyToOne
    @JoinColumn(name = "following_id")
    private Users following; // User who is being followed


    private Timestamp timestamp;
}
