package br.com.richard.resource.request;

import javax.json.bind.annotation.JsonbProperty;

public class UsuarioRequest {

    private String nome;
    private String cpf;

    @JsonbProperty(value = "username")
    private String userName;
    private String password;
}
