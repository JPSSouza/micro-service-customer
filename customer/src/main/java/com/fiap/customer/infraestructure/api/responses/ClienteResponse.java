package com.fiap.customer.infraestructure.api.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ClienteResponse {

    @NotBlank(message = "O cpf não pode ser nulo")
    @JsonProperty("cpf")
    private String cpf;

    @NotBlank(message = "O email não pode ser nulo")
    @JsonProperty("email")
    private String email;

    @NotBlank(message = "O nome não pode ser nulo")
    @JsonProperty("nome")
    private String nome;
}
