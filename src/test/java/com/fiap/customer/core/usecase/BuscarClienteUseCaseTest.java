package com.fiap.customer.core.usecase;

import com.fiap.customer.core.ports.out.BuscarClienteOutputPort;
import com.fiap.customer.core.usecase.BuscarClienteUseCase;
import com.fiap.customer.infraestructure.api.responses.ClienteResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class BuscarClienteUseCaseTest {

    @Mock
    BuscarClienteOutputPort buscarClienteOutputPort;
    @Mock
    private ClienteResponse clienteResponse;
    AutoCloseable mock;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void deveTestarBuscarClienteUsecase(){

        BuscarClienteUseCase buscarClienteUseCase = new BuscarClienteUseCase(buscarClienteOutputPort);
        var cpf = "545.464.180-43";
        when(buscarClienteOutputPort.buscar(any(String.class))).thenReturn(clienteResponse);
        ClienteResponse response = buscarClienteUseCase.buscarCliente(cpf);
        assertNotNull(response);
        assertInstanceOf(ClienteResponse.class, clienteResponse);

    }
}