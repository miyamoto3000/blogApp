package com.example.blogApp;
import com.example.blogApp.services.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blogApp.model.Post;
import com.example.blogApp.model.User;
import com.example.blogApp.repository.PostRepository;
import com.example.blogApp.repository.UserRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class test {

    private final PostService postService; 
    
    private final UserRepository userRepository;

    private final PostRepository postRepository;  

    public test(UserRepository userRepository,PostRepository postRepository, PostService postService)
    {
        this.userRepository=userRepository; 
        this.postRepository=postRepository; 
        this.postService = postService;
    } 


    @PostMapping("/test/user")

    public User creatUser(@RequestBody User user)
    {
            return userRepository.save(user);
    } 

    @PostMapping("/test/post")

    public Post creatPost(@RequestBody Post post , @RequestParam String authorId){
         return postService.creatPost(post, authorId);
    }
}
