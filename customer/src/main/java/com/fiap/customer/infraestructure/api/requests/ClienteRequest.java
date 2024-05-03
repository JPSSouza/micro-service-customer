package com.fiap.customer.infraestructure.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ClienteRequest {

    @NotBlank(message = "CPF não pode ser vazio!")
    @JsonProperty("cpf")
    private String cpf;

    @NotBlank(message = "Email não pode ser vazio!")
    @JsonProperty("email")
    private String email;

    @NotBlank(message = "Nome não pode ser vazio!")
    @JsonProperty("nome")
    private String nome;
}
