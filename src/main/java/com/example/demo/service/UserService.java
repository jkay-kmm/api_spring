package com.example.demo.service;

import com.example.demo.dto.request.UserCreationRequest;
import com.example.demo.dto.request.UserUpdateRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request){
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        user.setName(request.getName());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }
    public List<User>  getUser(){
        return userRepository.findAll();
    }
    public User getUser(String id){
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("User Not Found"));
    }
    public User updateUser( String userId, UserUpdateRequest request){
        User user = getUser(userId);
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        user.setDob(request.getDob());
        return userRepository.save(user);// luu lai cai entity nay
    }
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
