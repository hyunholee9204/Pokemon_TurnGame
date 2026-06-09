package com.example.Loguelike_Pokemon.Service;

import com.example.Loguelike_Pokemon.Entity.UserEntity;
import com.example.Loguelike_Pokemon.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(UserEntity user) {
        userRepository.save(user);
    }

    public UserEntity login(String userId, String userPw) {
        return userRepository.findByUserId(userId)
                .filter(user -> user.getUserPw().equals(userPw))
                .orElse(null);
    }

}