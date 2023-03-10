package com.jp.springapi.services;

import com.jp.springapi.dto.UserDTO;
import com.jp.springapi.entities.User;
import com.jp.springapi.repositories.UserRepository;
import com.jp.springapi.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//Para testar os Metodos da Classe preciso importar tudo que está sendo usado nela, o Repositorio, um User, UserDTO, ModelMapper, e um optional pq ele retorna um optional
@SpringBootTest
class UserServiceTest {

    public static final long ID = 1L;
    public static final String NAME = "Joao";
    public static final String EMAIL = "algamerjoao1@lol.com";
    public static final String PASSWORD = "65479789";
    //Estou Injetando A Classe Principal para o Teste
    //É necessário user essa anotação para esta classe pois ela vai acessar os repositorios e etc..
    @InjectMocks
    private UserService userService;

    //Sub-Classes ou Bibliotecas que serão utilizado pela classe principal de teste
    @Mock
    private UserRepository userRepository;

    @Mock
    private ModelMapper modelMapper;

    private User user;
    private UserDTO userDTO;
    private Optional<User> optionalUser;

    //Vai ser o Primeiro metodo a ser iniciado!
    @BeforeEach
    void setUp() {
        //Aqui eu permito os Mocks estanciados logo a cima
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void findAllUsers() {
    }

    @Test
    void findUserById() {

        //Quando esse metodo for chamado qualquer valor que for passado para ele, ele retorna um optionalUser
        Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(optionalUser);

        //Aqui ele Realmemte pega um Usuario do banco
        User response = userService.findUserById(ID);

        //Vai verificar se o usuario não vai ser nulo
        Assertions.assertNotNull(response);

        //O Assertions faz a comparação de duas classes e veririca se ela é igual
        Assertions.assertEquals(User.class, response.getClass());
        //Estou Comparando se o ID esperado vai ser o mesmo ID pegado do banco!
        Assertions.assertEquals(ID, response.getId());
        //Estou Comparando se o Nome esperado vai ser o mesmo ID pegado do banco!
        Assertions.assertEquals(NAME, response.getNome());
        //Estou Comparando se o Email esperado vai ser o mesmo ID pegado do banco!
        Assertions.assertEquals(EMAIL, response.getEmail());
    }

    //Toda vez que o metodo for executado e não encontrar um usuário, ele vai retornar uma Exception.
    @Test
    void findUserByIdReturnObjectNotFoundException(){
        //Quando chamar o metodo findById estoure uma Exception do Tipo ObjectNotFoundException com essa mensagem.
        Mockito.when(userRepository.findById(Mockito.anyLong())).thenThrow(new ObjectNotFoundException("Usuário Não Encontrado"));

        try{
        userService.findUserById(ID);
        }catch (Exception ex){
            //Estou Comparando minha Exception ObjectNotFound com o erro da Exception, se for o mesma Exception vai passar no teste.
            Assertions.assertEquals(ObjectNotFoundException.class, ex.getClass());
            //Estou comparando se as mensagens são iguais! , se forem iguais significa que é integro!
            Assertions.assertEquals("Usuário Não Encontrado", ex.getMessage());
        }
    }

    @Test
    void addUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }

    private void startUser(){
        user = new User(ID , NAME, EMAIL, PASSWORD);
        userDTO = new UserDTO(ID , NAME, EMAIL, PASSWORD);
        optionalUser = Optional.of(new User(ID , NAME, EMAIL, PASSWORD));
    }

}