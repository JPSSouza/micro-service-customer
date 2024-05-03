package com.fiap.customer.infraestructure.adapters;


import com.fiap.customer.core.domains.entities.ClienteDTO;
import com.fiap.customer.core.domains.exception.ClienteNaoEncontradoException;
import com.fiap.customer.core.domains.exception.ExceptionsMessageEnum;
import com.fiap.customer.core.ports.out.EditarClienteOutputPort;
import com.fiap.customer.infraestructure.persistence.entities.ClienteEntity;
import com.fiap.customer.infraestructure.persistence.mappers.ClienteEntityMapper;
import com.fiap.customer.infraestructure.persistence.repositorys.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EditarClienteAdapter implements EditarClienteOutputPort {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    ClienteEntityMapper clienteMapper;
    @Override
    public void editar(ClienteDTO cliente) {

        Optional<ClienteEntity> clienteEntity = clienteRepository.findById(cliente.getCpf());
        if(clienteEntity.isPresent()){

            clienteEntity.get().setCpf(cliente.getCpf());
            clienteEntity.get().setNome(cliente.getNome());
            clienteEntity.get().setEmail(cliente.getEmail());

            clienteRepository.save(clienteEntity.get());
        }else{

            throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.CLIENTE_NAO_ENCONTRADO.value());
        }
    }
}
