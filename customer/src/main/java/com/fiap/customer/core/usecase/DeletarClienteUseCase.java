package com.fiap.customer.core.usecase;

import com.fiap.customer.core.ports.in.DeletarClienteInputPort;
import com.fiap.customer.core.ports.out.DeletarClienteOutputPort;

public class DeletarClienteUseCase implements DeletarClienteInputPort {

    private final DeletarClienteOutputPort deletarClienteOutputPort;

    public DeletarClienteUseCase(DeletarClienteOutputPort deletarClienteOutputPort) {
        this.deletarClienteOutputPort = deletarClienteOutputPort;
    }

    @Override
    public void deletar(String cpf) {
        deletarClienteOutputPort.deletar(cpf);
    }
}
