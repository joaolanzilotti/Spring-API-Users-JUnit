package com.jp.springapi.services;

import com.jp.springapi.entities.User;
import com.jp.springapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> listUserById(Long id){
        return userRepository.findById(id);
    }

}
