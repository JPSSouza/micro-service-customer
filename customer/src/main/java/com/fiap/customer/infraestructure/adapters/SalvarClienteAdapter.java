package com.fiap.customer.infraestructure.adapters;

import com.fiap.customer.core.domains.entities.ClienteDTO;
import com.fiap.customer.core.ports.out.SalvarClienteOutputPort;
import com.fiap.customer.infraestructure.persistence.mappers.ClienteEntityMapper;
import com.fiap.customer.infraestructure.persistence.repositorys.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SalvarClienteAdapter implements SalvarClienteOutputPort {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteEntityMapper clienteEntityMapper;
    @Override
    public void salvar(ClienteDTO cliente) {

        var clienteEntity = clienteEntityMapper.toClienteEntity(cliente);
        clienteRepository.save(clienteEntity);
    }
}
