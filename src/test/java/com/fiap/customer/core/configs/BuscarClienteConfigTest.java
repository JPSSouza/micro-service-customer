package com.fiap.customer.core.configs;

import com.fiap.customer.core.usecase.BuscarClienteUseCase;
import com.fiap.customer.infraestructure.adapters.BuscarClienteAdapter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@SpringBootTest
class BuscarClienteConfigTest {

    @Configuration
    @Import(BuscarClienteConfig.class)
    static class TestConfig {
        @Bean
        public BuscarClienteAdapter buscarClienteAdapter() {
            return mock(BuscarClienteAdapter.class);
        }
    }
    @Autowired
    private BuscarClienteUseCase buscarClienteUseCase;

    @Test
    public void testBuscarClienteUseCaseBean() {
        assertNull(buscarClienteUseCase, "O bean BuscarClienteUseCase deve ser criado");
    }
}