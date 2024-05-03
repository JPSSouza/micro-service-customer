package com.fiap.customer.infraestructure.adapters;

import com.fiap.customer.core.domains.exception.ClienteNaoEncontradoException;
import com.fiap.customer.core.domains.exception.ExceptionsMessageEnum;
import com.fiap.customer.core.ports.out.BuscarClienteOutputPort;
import com.fiap.customer.infraestructure.api.mappers.ClienteMapper;
import com.fiap.customer.infraestructure.api.responses.ClienteResponse;
import com.fiap.customer.infraestructure.persistence.entities.ClienteEntity;
import com.fiap.customer.infraestructure.persistence.repositorys.ClienteRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BuscarClienteAdapter implements BuscarClienteOutputPort {
    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public BuscarClienteAdapter(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public ClienteResponse buscar(String cpf) {

        Optional<ClienteEntity> cliente = clienteRepository.findById(cpf);

        if(cliente.isPresent()){
            return clienteMapper.toClienteResponse(cliente.get());
        }else{
            throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.CLIENTE_NAO_ENCONTRADO.value());
        }
    }
}
