package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable("id") Integer id){
        User user = userService.getUser(id);
        if(user!=null){
            logger.info("found user ",user);
            return ResponseEntity.ok(user);
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity saveUser(@RequestBody User user){
            userService.createUser(user);
            logger.info("found user ",user);
        if(user.getId()>0){
            return ResponseEntity.ok(user);
        }else {
            return ResponseEntity.noContent().build();
        }
    }
}

