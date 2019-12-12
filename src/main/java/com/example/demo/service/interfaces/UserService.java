package com.example.demo.service.interfaces;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(Integer id);

    User updateuser(User user);

    User createUser(User user);

    void deleteUser(Integer id);



}
