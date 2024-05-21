package com.fiap.customer.core.ports.out;

import com.fiap.customer.core.domains.entities.ClienteDTO;

public interface EditarClienteOutputPort {
    void editar(ClienteDTO cliente);
}
