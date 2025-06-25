package com.example.blogApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.blogApp.model.Post;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByCategory(String category);
    List<Post> findByAuthorId(String authorId);
}