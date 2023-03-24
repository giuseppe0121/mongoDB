package com.example.mongoDB.service;

import com.example.mongoDB.entities.User;
import com.example.mongoDB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User creationUser(User user){

        return userRepository.save(user);

    }

    public Optional<User> getUserById(String id) throws Exception {

        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user;
        }else {
            throw new Exception("user not found");
        }
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User updateUser(String id,User user) throws Exception {

        if(!userRepository.existsById(id)){
            throw new Exception("User not found");
        }
        user.setId(id);
        return userRepository.save(user);
    }

    public void delateUser(String id){
        userRepository.deleteById(id);
    }

}
