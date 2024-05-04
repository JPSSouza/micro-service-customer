
package com.fiap.customer.core.usecase;

import com.fiap.customer.core.ports.in.BuscarClienteInputPort;
import com.fiap.customer.core.ports.out.BuscarClienteOutputPort;
import com.fiap.customer.infraestructure.api.responses.ClienteResponse;

public class BuscarClienteUseCase implements BuscarClienteInputPort {
    private final BuscarClienteOutputPort buscarClienteOutputPort;
    public BuscarClienteUseCase(BuscarClienteOutputPort buscarClienteOutputPort) {
        this.buscarClienteOutputPort = buscarClienteOutputPort;
    }
    @Override
    public ClienteResponse buscarCliente(String cpf) {
        return this.buscarClienteOutputPort.buscar(cpf);
    }
}

