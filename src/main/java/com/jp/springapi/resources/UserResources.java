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
import java.util.stream.Collectors;

@RestController
@RequestMapping(value =  "/user")
public class UserResources {

    //Usado Para Mapear uma Classe Entity para Uma Classe DTO, Instalado Dependencia para isso!
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAllUsers(){
        //Com o Stream Estou Pegando Cada Elemento da Lista User e com o ModelMapper eu Mapeio Cada Elemento da lista x para um elemento da Classe UserDTO e retorno uma Lista
        List<UserDTO> listAllUsersDTO = userService.findAllUsers()
                .stream()
                .map(x -> modelMapper.map(x, UserDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(listAllUsersDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findByIdUser(@PathVariable Long id){
        return ResponseEntity.ok().body(modelMapper.map(userService.findUserById(id), UserDTO.class));
    }

}
