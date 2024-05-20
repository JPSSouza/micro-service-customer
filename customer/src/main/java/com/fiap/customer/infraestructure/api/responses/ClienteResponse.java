package com.fiap.customer.infraestructure.api.responses;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteResponse {

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("email")
    private String email;

    @JsonProperty("nome")
    private String nome;
}
