package com.fiap.customer.infraestructure.adapters;

import com.fiap.customer.core.domains.entities.ClienteDTO;
import com.fiap.customer.core.ports.out.SalvarClienteOutputPort;
import com.fiap.customer.infraestructure.persistence.entities.ClienteEntity;
import com.fiap.customer.infraestructure.persistence.repositorys.ClienteRepository;
import com.fiap.customer.infraestructure.utils.mappers.ClienteMapper;
import org.springframework.stereotype.Component;


@Component
public class SalvarClienteAdapter implements SalvarClienteOutputPort {
    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;
    public SalvarClienteAdapter(ClienteRepository clienteRepository, ClienteMapper clienteMapper){
        this.clienteRepository      = clienteRepository;
        this.clienteMapper    = clienteMapper;
    }
    @Override
    public void salvar(ClienteDTO cliente) {

        ClienteEntity clienteEntity = clienteMapper.toClienteEntity(cliente);
        clienteRepository.save(clienteEntity);
    }
}
