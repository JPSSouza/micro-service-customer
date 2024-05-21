package com.fiap.customer.core.usecase;

import com.fiap.customer.core.ports.out.DeletarClienteOutputPort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class DeletarClienteUseCaseTest {

    @Mock
    DeletarClienteOutputPort deletarClienteOutputPort;
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
    public void deveTestardeletarClienteUsecase() {

        DeletarClienteUseCase deletarClienteUseCase = new DeletarClienteUseCase(deletarClienteOutputPort);
        var cpf = "545.464.180-43";
        doNothing().when(deletarClienteOutputPort).deletar(any(String.class));
        deletarClienteUseCase.deletar(cpf);

        verify(deletarClienteOutputPort, times(1)).deletar(any(String.class));
    }
}