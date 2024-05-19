package com.fiap.customer.core.configs;

import com.fiap.customer.core.usecase.BuscarClienteUseCase;
import com.fiap.customer.core.usecase.EditarClienteUseCase;
import com.fiap.customer.infraestructure.adapters.BuscarClienteAdapter;
import com.fiap.customer.infraestructure.adapters.EditarClienteAdapter;
import com.fiap.customer.infraestructure.utils.mappers.ClienteMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class EditarClienteConfigTest {

    @Mock
    EditarClienteAdapter editarClienteAdapter;
    @Mock
    ClienteMapper clienteMapper;
    @InjectMocks
    EditarClienteConfig editarClientConfig;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testEditarClienteUseCaseBean() {

        EditarClienteUseCase editarClienteUseCase = editarClientConfig.editarClienteUseCase(editarClienteAdapter, clienteMapper);

        assertNotNull(editarClienteUseCase, "O bean EditarClienteUseCase deve ser criado");
    }
}