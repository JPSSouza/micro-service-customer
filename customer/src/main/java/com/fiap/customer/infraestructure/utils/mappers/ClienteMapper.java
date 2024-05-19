package com.fiap.customer.infraestructure.utils.mappers;


import com.fiap.customer.core.domains.entities.ClienteDTO;
import com.fiap.customer.infraestructure.api.requests.ClienteRequest;
import com.fiap.customer.infraestructure.api.responses.ClienteResponse;
import com.fiap.customer.infraestructure.persistence.entities.ClienteEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteDTO toCliente(ClienteRequest clienteRequest);
    ClienteResponse toClienteResponse(ClienteEntity clienteEntity);
    ClienteEntity toClienteEntity(ClienteDTO clienteDTO);
}
