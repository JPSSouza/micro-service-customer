package com.fiap.customer.core.ports.in;


import com.fiap.customer.infraestructure.api.responses.ClienteResponse;

public interface BuscarClienteInputPort {
    ClienteResponse buscarCliente(String cpf);
}
