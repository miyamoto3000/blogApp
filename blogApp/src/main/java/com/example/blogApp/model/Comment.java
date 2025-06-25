package com.example.blogApp.model;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import java.time.LocalDateTime; 
import lombok.*;

@Document(collation = "comments")
public class Comment {
    @Id 
    private String id;
    private String content;
    private String postId;
    private String authorId;
    private LocalDateTime createdAt;
}
