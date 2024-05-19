package com.fiap.customer.core.configs;

import com.fiap.customer.core.usecase.DeletarClienteUseCase;
import com.fiap.customer.infraestructure.adapters.DeletarClienteAdapter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

@SpringBootTest(classes = {DeletarClienteConfigTest.TestConfig.class, DeletarClienteConfig.class})
public class DeletarClienteConfigTest {
    @Configuration
    static class TestConfig {
        @Bean
        public DeletarClienteAdapter deletarClienteAdapter() {
            return mock(DeletarClienteAdapter.class);
        }
    }
    @Autowired
    private DeletarClienteUseCase deletarClienteUseCase;
    @Test
    public void testDeletarClienteUseCaseBean() {
        assertNotNull(deletarClienteUseCase, "O bean DeletarClienteUseCase deve ser criado");
    }
}