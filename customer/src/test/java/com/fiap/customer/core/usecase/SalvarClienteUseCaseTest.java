package com.fiap.customer.core.usecase;

import com.fiap.customer.core.domains.entities.ClienteDTO;
import com.fiap.customer.core.ports.out.EditarClienteOutputPort;
import com.fiap.customer.core.ports.out.SalvarClienteOutputPort;
import com.fiap.customer.infraestructure.api.mappers.ClienteMapper;
import com.fiap.customer.infraestructure.api.requests.ClienteRequest;
import com.fiap.customer.infraestructure.persistence.entities.ClienteEntity;
import com.fiap.customer.infraestructure.persistence.mappers.ClienteEntityMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class SalvarClienteUseCaseTest {

    @Mock
    SalvarClienteOutputPort salvarClienteOutputPort;

    @Mock
    ClienteMapper mapper;

    @Mock
    ClienteEntity clienteEntity;

    @Mock
    ClienteRequest clienteRequest;

    @Mock
    ClienteDTO clienteDTO;

    AutoCloseable mock;
    @BeforeEach
    void setUp() {
        mock = MockitoAnnotations.openMocks(this);
    }
    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Test
    public void deveTestarSalvarClienteUsecase(){

        SalvarClienteUseCase salvarClienteUseCase = new SalvarClienteUseCase(salvarClienteOutputPort,mapper);

        doNothing().when(salvarClienteOutputPort).salvar(any(ClienteDTO.class));
        when(mapper.toCliente(any(ClienteRequest.class))).thenReturn(clienteDTO);
        salvarClienteUseCase.salvar(clienteRequest);

        verify(salvarClienteOutputPort,times(1)).salvar(clienteDTO);
        verify(mapper,times(1)).toCliente(clienteRequest);
    }
}