package com.fiap.customer.infraestructure.adapters;

import com.fiap.customer.core.domains.exception.ClienteNaoEncontradoException;
import com.fiap.customer.core.domains.exception.ExceptionsMessageEnum;
import com.fiap.customer.core.ports.out.DeletarClienteOutputPort;
import com.fiap.customer.infraestructure.persistence.entities.ClienteEntity;
import com.fiap.customer.infraestructure.persistence.repositorys.ClienteRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DeletarClienteAdapter implements DeletarClienteOutputPort {
    private final ClienteRepository clienteRepository;
    public DeletarClienteAdapter(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }
    @Override
    public void deletar(String cpf) {
        Optional<ClienteEntity> cliente = clienteRepository.findById(cpf);
        if(cliente.isPresent()){
            clienteRepository.deleteById(cpf);
        }else{
            throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.CLIENTE_NAO_ENCONTRADO.value());
        }
    }
}
