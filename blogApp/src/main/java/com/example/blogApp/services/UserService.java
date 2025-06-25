package com.example.blogApp.services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.blogApp.model.User;
import com.example.blogApp.repository.UserRepository; 

@Service 

public class UserService {
     
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }  

    public User createUser(User user){
        return userRepository.save(user); 
    } 

    public List<User>getAllUsers(){
        return userRepository.findAll();
    } 

    public User getUserById(String id){
         return userRepository.findById(id)
               .orElseThrow(()->new RuntimeException("User not found"));
    }



}
