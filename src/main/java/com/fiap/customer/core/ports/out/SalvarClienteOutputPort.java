package com.fiap.customer.core.ports.out;

import com.fiap.customer.core.domains.entities.ClienteDTO;

public interface SalvarClienteOutputPort {
    void salvar(ClienteDTO cliente);
}
