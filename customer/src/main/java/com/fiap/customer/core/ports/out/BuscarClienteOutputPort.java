package com.fiap.customer.core.ports.out;

import com.fiap.customer.infraestructure.api.responses.ClienteResponse;

public interface BuscarClienteOutputPort {

    ClienteResponse buscar (String cpf);
}
