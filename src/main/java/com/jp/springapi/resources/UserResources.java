package com.jp.springapi.resources;

import com.jp.springapi.entities.User;
import com.jp.springapi.services.UserService;
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

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findALlUsers(){
        List<User> listAllUsers = userService.listAllUsers();
        return ResponseEntity.ok().body(listAllUsers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findByIdUser(@PathVariable Long id){
        User user = userService.listUserById(id);
        return ResponseEntity.ok().body(user);
    }

}
