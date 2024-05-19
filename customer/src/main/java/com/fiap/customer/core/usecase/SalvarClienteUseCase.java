package com.fiap.customer.core.usecase;

import com.fiap.customer.core.ports.in.SalvarClienteInputport;
import com.fiap.customer.core.ports.out.SalvarClienteOutputPort;
import com.fiap.customer.infraestructure.utils.mappers.ClienteMapper;
import com.fiap.customer.infraestructure.api.requests.ClienteRequest;

public class SalvarClienteUseCase implements SalvarClienteInputport {

    private final SalvarClienteOutputPort salvarClienteOutputPort;
    private final ClienteMapper clienteMapper;
    public SalvarClienteUseCase(SalvarClienteOutputPort salvarClienteOutputPort, ClienteMapper clienteMapper) {
        this.salvarClienteOutputPort = salvarClienteOutputPort;
        this.clienteMapper = clienteMapper;
    }
    @Override
    public void salvar(ClienteRequest clienteRequest) {
        var cliente = clienteMapper.toCliente(clienteRequest);
        salvarClienteOutputPort.salvar(cliente);
    }
}
