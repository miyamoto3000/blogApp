package com.example.blogApp.model;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import java.time.LocalDateTime; 
import lombok.*;

@Data 

@Document(collection = "posts")
public class Post {
     
    private String id;
    private String title;
    private String content;
    private String category;
    private String authorId;
    private int likes;
    private LocalDateTime createdAt;
    
}
