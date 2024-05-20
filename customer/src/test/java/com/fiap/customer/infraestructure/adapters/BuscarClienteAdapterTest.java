package com.fiap.customer.infraestructure.adapters;

import com.fiap.customer.core.domains.exception.ClienteNaoEncontradoException;
import com.fiap.customer.infraestructure.utils.mappers.ClienteMapper;
import com.fiap.customer.infraestructure.api.responses.ClienteResponse;
import com.fiap.customer.infraestructure.persistence.entities.ClienteEntity;
import com.fiap.customer.infraestructure.persistence.repositorys.ClienteRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class BuscarClienteAdapterTest {
    AutoCloseable openMocks;
    @InjectMocks
    BuscarClienteAdapter buscarClienteAdapter;
    @Mock
    ClienteRepository clienteRepository;
    @Mock
    ClienteMapper clienteMapper;
    @Mock
    ClienteEntity entity;
    @Mock
    ClienteResponse clienteResponse;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @Test
    public void deveTestarBuscarClienteAdapter(){

        var cpf = "545.464.180-43";

        when(clienteRepository.findById(any(String.class))).thenReturn(Optional.of(entity));
        when(clienteMapper.toClienteResponse(any(ClienteEntity.class))).thenReturn(clienteResponse);

        var cliente = buscarClienteAdapter.buscar(cpf);

        assertNotNull(cliente);
        assertInstanceOf(ClienteResponse.class, cliente);
    }

    @Test
    public void deveLancarExceptionClienteNaoEncontradoNoBuscarClienteAdapter(){

        var cpf = "545.464.180-43";

        when(clienteRepository.findById(any(String.class))).thenReturn(Optional.empty());

        ClienteNaoEncontradoException erro = assertThrows(ClienteNaoEncontradoException.class, ()-> buscarClienteAdapter.buscar(cpf));

        assertNotNull(erro);
        assertTrue(erro.getMessage().contains("Cliente não encontrado!"));

    }
}