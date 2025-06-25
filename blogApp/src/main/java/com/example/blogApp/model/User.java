package com.example.blogApp.model;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import java.util.HashSet;
import java.util.Set;   
import lombok.*;

@Document(collection="users")
@Data
public class User {
    private String id;
    private String username;
    private String password;
    private String email;
    private Set<String>likedPosts=new HashSet<>();
}
