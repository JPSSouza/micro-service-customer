package com.fiap.customer.infraestructure.adapters;

import com.fiap.customer.core.domains.exception.ClienteNaoEncontradoException;
import com.fiap.customer.core.domains.exception.ExceptionsMessageEnum;
import com.fiap.customer.core.ports.out.DeletarClienteOutputPort;
import com.fiap.customer.infraestructure.persistence.repositorys.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeletarClienteAdapter implements DeletarClienteOutputPort {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public void deletar(String cpf) {
        var cliente = clienteRepository.findById(cpf);
        if(cliente.isPresent()){
            clienteRepository.deleteById(cpf);
        }else{
            throw new ClienteNaoEncontradoException(ExceptionsMessageEnum.CLIENTE_NAO_ENCONTRADO.value());
        }
    }
}
