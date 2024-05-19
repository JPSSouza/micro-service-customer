package com.fiap.customer.infraestructure.adapters;


import com.fiap.customer.core.domains.entities.ClienteDTO;
import com.fiap.customer.core.domains.exception.ClienteNaoEncontradoException;
import com.fiap.customer.core.domains.exception.ExceptionsMessageEnum;
import com.fiap.customer.core.ports.out.EditarClienteOutputPort;
import com.fiap.customer.infraestructure.persistence.entities.ClienteEntity;
import com.fiap.customer.infraestructure.persistence.repositorys.ClienteRepository;
import com.fiap.customer.infraestructure.utils.mappers.ClienteMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EditarClienteAdapter implements EditarClienteOutputPort {

    private final ClienteRepository clienteRepository;

    private final ClienteMapper clienteMapper;

    public EditarClienteAdapter(ClienteRepository clienteRepository, ClienteMapper clienteMapper){
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public void editar(ClienteDTO cliente) {

        Optional<ClienteEntity> clienteEntity = clienteRepository.findById(cliente.getCpf());
        if(clienteEntity.isPresent()){

            clienteMapper.toClienteEntity(cliente);

            clienteRepository.save(clienteEntity.get());
        }else{

            throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.CLIENTE_NAO_ENCONTRADO.value());
        }
    }
}
