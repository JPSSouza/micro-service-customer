package com.fiap.customer.core.usecase;

import com.fiap.customer.core.domains.entities.ClienteDTO;
import com.fiap.customer.core.ports.out.EditarClienteOutputPort;
import com.fiap.customer.infraestructure.api.mappers.ClienteMapper;
import com.fiap.customer.infraestructure.api.requests.ClienteRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class EditarClienteUseCaseTest {

    @Mock
    EditarClienteOutputPort editarClienteOutputPort;
    @Mock
    private ClienteMapper clienteMapper;

    @Mock
    private ClienteRequest clienteRequest;

    @Mock
    private ClienteDTO clienteDTO;

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
    public void deveTestarEditarClienteUsecase(){

        EditarClienteUseCase editarClienteUseCase = new EditarClienteUseCase(editarClienteOutputPort,clienteMapper);


        doNothing().when(editarClienteOutputPort).editar(clienteDTO);
        when(clienteMapper.toCliente(clienteRequest)).thenReturn(clienteDTO);
        editarClienteUseCase.editar(clienteRequest);

        verify(editarClienteOutputPort,times(1)).editar(clienteDTO);
        verify(clienteMapper,times(1)).toCliente(clienteRequest);
    }

}