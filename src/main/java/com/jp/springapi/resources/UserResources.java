package com.jp.springapi.resources;

import com.jp.springapi.dto.UserDTO;
import com.jp.springapi.entities.User;
import com.jp.springapi.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value =  "/user")
public class UserResources {

    //Usado Para Mapear uma Classe Entity para Uma Classe DTO, Instalado Dependencia para isso!
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findALlUsers(){
        List<User> listAllUsers = userService.listAllUsers();
        return ResponseEntity.ok().body(listAllUsers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findByIdUser(@PathVariable Long id){
        return ResponseEntity.ok().body(modelMapper.map(userService.listUserById(id), UserDTO.class));
    }

}
