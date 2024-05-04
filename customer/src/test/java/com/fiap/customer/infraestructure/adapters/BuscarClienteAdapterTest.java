package com.fiap.customer.infraestructure.adapters;

import com.fiap.customer.core.domains.exception.ClienteNaoEncontradoException;
import com.fiap.customer.infraestructure.api.mappers.ClienteMapper;
import com.fiap.customer.infraestructure.api.responses.ClienteResponse;
import com.fiap.customer.infraestructure.persistence.entities.ClienteEntity;
import com.fiap.customer.infraestructure.persistence.repositorys.ClienteRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class BuscarClienteAdapterTest {
    AutoCloseable openMocks;

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
    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    public void deveTestarBuscarClienteAdapter(){

        var cpf = "545.464.180-43";
        BuscarClienteAdapter adapter = new BuscarClienteAdapter(clienteRepository, clienteMapper);
        when(clienteRepository.findById(any(String.class))).thenReturn(Optional.of(entity));
        when(clienteMapper.toClienteResponse(any(ClienteEntity.class))).thenReturn(clienteResponse);

        var cliente = adapter.buscar(cpf);

        assertNotNull(cliente);
        assertInstanceOf(ClienteResponse.class, cliente);
    }

    @Test
    public void deveLancarExceptionClienteNaoEncontradoNoBuscarClienteAdapter(){

        var cpf = "545.464.180-43";
        BuscarClienteAdapter adapter = new BuscarClienteAdapter(clienteRepository, clienteMapper);
        when(clienteRepository.findById(any(String.class))).thenReturn(Optional.empty());

        ClienteNaoEncontradoException erro = assertThrows(ClienteNaoEncontradoException.class, ()-> adapter.buscar(cpf));

        assertNotNull(erro);
        assertTrue(erro.getMessage().contains("Cliente não encontrado!"));

    }
}