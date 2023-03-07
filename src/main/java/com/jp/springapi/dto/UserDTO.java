package com.jp.springapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String nome;
    private String email;
    //com o JsonProperty(acess = JsonProperty.Acess.WRITE_ONLY) permite o acesso apenas para escrita, e não mostra a Senha!
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

}
