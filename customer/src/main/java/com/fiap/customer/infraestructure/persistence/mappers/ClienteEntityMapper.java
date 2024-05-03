package com.fiap.customer.infraestructure.persistence.mappers;

import com.fiap.customer.core.domains.entities.ClienteDTO;
import com.fiap.customer.infraestructure.persistence.entities.ClienteEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ClienteEntityMapper {
    ClienteEntity toClienteEntity(ClienteDTO cliente);
}
