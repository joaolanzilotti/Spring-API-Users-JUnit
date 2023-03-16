package com.jp.springapi.resources;

import com.jp.springapi.dto.UserDTO;
import com.jp.springapi.entities.User;
import com.jp.springapi.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserResourcesTest {

    public static final long ID = 1L;
    public static final String NAME = "Joao";
    public static final String EMAIL = "algamerjoao1@lol.com";
    public static final String PASSWORD = "65479789";

    //O InjectMocks diz que a classe vai ser metirinha, dados aleatorios. Classes de mentirinha
    @InjectMocks
    private UserResources userResources;
    @Mock
    private ModelMapper modelMapper;

    @Mock
    private UserService userService;

    private User user;
    private UserDTO userDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void findAllUsers() {
    }

    @Test
    void findByIdUser() {
    }

    @Test
    void addUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void delete() {
    }

    private void startUser(){
        user = new User(ID , NAME, EMAIL, PASSWORD);
        userDTO = new UserDTO(ID , NAME, EMAIL, PASSWORD);
    }

}