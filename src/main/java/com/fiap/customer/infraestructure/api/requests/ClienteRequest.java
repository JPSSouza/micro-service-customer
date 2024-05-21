package com.fiap.customer.infraestructure.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
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
