package com.example.blogApp.services;
import org.springframework.stereotype.Service;

import com.example.blogApp.model.Post;
import com.example.blogApp.model.User;
import com.example.blogApp.repository.PostRepository;
import com.example.blogApp.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors; 

@Service

public class PostService {
     private final PostRepository postRepository;
     private final UserRepository userRepository;
      
     public PostService(PostRepository postRepository, UserRepository userRepository){
        this.postRepository=postRepository;
        this.userRepository=userRepository;
     } 

     public Post creatPost(Post post ,String authorId){
           userRepository.findById(authorId)
           .orElseThrow(()->new RuntimeException("author not found"));

           post.setAuthorId(authorId);

           post.setCreatedAt(LocalDateTime.now());
           post.setLikes(0);
           return postRepository.save(post);
     }   

     public List<Post> getPostsByCategory(String category){
        return postRepository.findByCategory(category);
     } 

     public List<Post> getPostsByAuthor(String authorId){
         return postRepository.findByAuthorId(authorId);
     } 

     public Post likePost(String userId,String postId)
     {
         Post post=postRepository.findById(postId)
             .orElseThrow(()->new RuntimeException("post not found"));
             
         User user=userRepository.findById(userId)
          .orElseThrow(() -> new RuntimeException("user not foound"));

          if(!user.getLikedPosts().contains(postId)){
              user.getLikedPosts().add(postId);
              post.setLikes(post.getLikes()+1);
              userRepository.save(user);
              postRepository.save(post);
          } 
          return post;
     } 

     public List<Post>getPopularPosts(){
          
        return postRepository.findAll().stream()
                   .filter(post -> post.getLikes()>0)
                   .sorted((p1, p2) -> Integer.compare(p2.getLikes(), p1.getLikes()))
                   .limit(5)
                   .collect(Collectors.toList());
     }
}
