package com.fiap.customer.core.ports.in;


import com.fiap.customer.infraestructure.api.requests.ClienteRequest;

public interface EditarClienteInputport {
    void editar(ClienteRequest clienteRequest);
}
