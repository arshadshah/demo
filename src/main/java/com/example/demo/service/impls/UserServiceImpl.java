package com.example.demo.service.impls;

import com.example.demo.dao.interfaces.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Integer id) {
        if(userRepository.existsById(id)) {
            return userRepository.getOne(id);
        }else{
            return null;
        }
    }

    @Override
    public User updateuser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        User user = userRepository.getOne(id);
        userRepository.delete(user);
    }
}
