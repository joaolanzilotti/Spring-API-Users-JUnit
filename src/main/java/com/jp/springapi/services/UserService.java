package com.jp.springapi.services;

import com.jp.springapi.entities.User;
import com.jp.springapi.repositories.UserRepository;
import com.jp.springapi.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers(){

        return userRepository.findAll();

    }

    public User findUserById(Long id){

        Optional<User> userById = userRepository.findById(id);

        return userById.orElseThrow(() -> new ObjectNotFoundException("Usuário Não Encontrado"));

    }

}
