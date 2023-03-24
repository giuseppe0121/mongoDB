package com.example.mongoDB.controller;

import com.example.mongoDB.entities.User;
import com.example.mongoDB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/create_user")
    public ResponseEntity postUser(@RequestBody User user){
        userService.creationUser(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/get_user/{id}")
    public ResponseEntity getUserById(@PathVariable String id) throws Exception {
        Optional<User> user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/get_all_user")
    public ResponseEntity getAllUsers(){
        List<User> user = userService.getAllUsers();
        return ResponseEntity.ok(user);
    }

    @PutMapping("/edit_user/{id}")
    public ResponseEntity editUser(@PathVariable String id, @RequestBody User user) throws Exception {
        user = userService.updateUser(id,user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable String id){
        userService.delateUser(id);
        return ResponseEntity.accepted().build();
    }

}
