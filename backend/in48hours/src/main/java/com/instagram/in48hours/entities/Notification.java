package com.instagram.in48hours.entities;

import java.sql.Timestamp;

import com.instagram.in48hours.user.NotificationType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

@Entity(name = "notification")
public class Notification {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user; // User who receives the notification

    @Enumerated(EnumType.STRING)
 
    private NotificationType type; // Enum representing the type of notification (e.g., LIKE, COMMENT, FOLLOW)

    @ManyToOne
    @JoinColumn(name = "source_user_id")
    private Users sourceUser; // User who triggered the notification (e.g., liked, commented, followed)

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post; // Related post, if applicable


    private Timestamp timestamp;
}
