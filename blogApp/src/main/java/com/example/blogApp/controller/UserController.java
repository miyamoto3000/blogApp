package com.example.blogApp.controller;
import org.springframework.web.bind.annotation.*;

import com.example.blogApp.model.User;
import com.example.blogApp.services.UserService;

import java.util.List;

@RestController 

@RequestMapping("api/users")

public class UserController {
     private final UserService userService; 
      
     public UserController(UserService userService){
        this.userService=userService;
     } 

     @PostMapping 

     public User CreatUser(@RequestBody User user){
          
        return userService.createUser(user);
     }  

     @GetMapping 

     public List<User> getAllUsers(){
        return userService.getAllUsers();
     } 

     @GetMapping("/id")
     public User getUserById(@PathVariable String id)
     {
        return userService.getUserById(id);
     }




}
