package com.example.blogApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.blogApp.model.Comment;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {
    List<Comment> findByPostId(String postId);
}
