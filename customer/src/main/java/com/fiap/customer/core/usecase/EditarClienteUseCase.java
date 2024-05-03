package com.fiap.customer.core.usecase;

import com.fiap.customer.core.ports.in.EditarClienteInputport;
import com.fiap.customer.core.ports.out.EditarClienteOutputPort;
import com.fiap.customer.infraestructure.api.mappers.ClienteMapper;
import com.fiap.customer.infraestructure.api.requests.ClienteRequest;

public class EditarClienteUseCase implements EditarClienteInputport {
    public final EditarClienteOutputPort editarClienteOutputPort;
    private final ClienteMapper clienteMapper;
    public EditarClienteUseCase(EditarClienteOutputPort editarClienteOutputPort, ClienteMapper clienteMapper) {
        this.editarClienteOutputPort = editarClienteOutputPort;
        this.clienteMapper = clienteMapper;
    }
    @Override
    public void editar(ClienteRequest clienteRequest) {
        var cliente = clienteMapper.toCliente(clienteRequest);
        editarClienteOutputPort.editar(cliente);
    }
}
