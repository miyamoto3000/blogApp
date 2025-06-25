package com.example.blogApp.controller;
import org.springframework.web.bind.annotation.*;

import com.example.blogApp.model.Post;
import com.example.blogApp.services.PostService;

import java.util.List;

@RestController 
@RequestMapping("/api/posts") 

public class PostController {
     
    private PostService postService;

    public PostController(PostService postService){
        this.postService=postService;
    } 

    public Post creatPosts(@RequestBody Post post,@RequestParam String authorId){ 
          return postService.creatPost(post, authorId);
    } 

    @GetMapping
    public List<Post> getPosts(@RequestParam(required = false) String category) {
        if (category != null) {
            return postService.getPostsByCategory(category);
        }
        return postService.getPostsByAuthor(null);
    }

    @GetMapping("/by-author/{authorId}")
    public List<Post> getPostsByAuthor(@PathVariable String authorId) {
        return postService.getPostsByAuthor(authorId);
    }

    @PostMapping("/{postId}/like")
    public Post likePost(@PathVariable String postId, @RequestParam String userId) {
        return postService.likePost(postId, userId);
    }

    @GetMapping("/popular")
    public List<Post> getPopularPosts() {
        return postService.getPopularPosts();
    }
}
