package com.fiap.customer.core.domains.entities;

import org.junit.jupiter.api.Test;
import utils.BeanGettersAndSettersTester;
import java.beans.IntrospectionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ClienteDTOTest {

    @Test
    public void validaGettersAndSettersClienteDTO() throws IntrospectionException {

        BeanGettersAndSettersTester.test(ClienteDTO.class);
    }
    @Test
    public void deveTestarConstructorClienteDTO(){

        var cpf = "00000000000";
        var email = "joao@email.com.br";
        var nome = "João Guilherme";

        ClienteDTO cliente = new ClienteDTO(cpf, email, nome);

        assertNotNull(cliente);
        assertEquals(cpf, cliente.getCpf());
        assertEquals(email, cliente.getEmail());
        assertEquals(nome, cliente.getNome());
    }



}