package com.fiap.customer.core.configs;

import com.fiap.customer.core.usecase.EditarClienteUseCase;
import com.fiap.customer.core.usecase.SalvarClienteUseCase;
import com.fiap.customer.infraestructure.adapters.EditarClienteAdapter;
import com.fiap.customer.infraestructure.adapters.SalvarClienteAdapter;
import com.fiap.customer.infraestructure.utils.mappers.ClienteMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class SalvarClienteConfigTest {
    @Mock
    SalvarClienteAdapter editarClienteAdapter;
    @Mock
    ClienteMapper clienteMapper;
    @InjectMocks
    SalvarClienteConfig salvarClientConfig;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testEditarClienteUseCaseBean() {

        SalvarClienteUseCase salvarClienteUseCase = salvarClientConfig.salvarClienteUseCase(editarClienteAdapter, clienteMapper);

        assertNotNull(salvarClienteUseCase, "O bean SalvarClienteUseCase deve ser criado");
    }
}