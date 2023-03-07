package com.jp.springapi.services;

import com.jp.springapi.dto.UserDTO;
import com.jp.springapi.entities.User;
import com.jp.springapi.repositories.UserRepository;
import com.jp.springapi.services.exceptions.DataIntegratyViolationException;
import com.jp.springapi.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User findUserById(Long id){
        Optional<User> userById = userRepository.findById(id);
        return userById.orElseThrow(() -> new ObjectNotFoundException("Usuário Não Encontrado"));
    }

    public User addUser(UserDTO userDTO){
        findByEmail(userDTO);
        return userRepository.save(modelMapper.map(userDTO, User.class));
    }

    public User updateUser(UserDTO userDTO){
        findByEmail(userDTO);
        return userRepository.save(modelMapper.map(userDTO, User.class));
    }

    private void findByEmail(UserDTO userDTO){
        Optional<User> user = userRepository.findByEmail(userDTO.getEmail());
        if(user.isPresent() && !user.get().getId().equals(userDTO.getId())){
            throw new DataIntegratyViolationException("E-mail Já Cadastrado no Sistema");
        }
    }

}
