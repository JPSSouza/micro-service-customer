package com.fiap.customer.core.configs;

import com.fiap.customer.core.usecase.DeletarClienteUseCase;
import com.fiap.customer.infraestructure.adapters.DeletarClienteAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarClienteConfig {
    @Bean
    public DeletarClienteUseCase deletarClienteUseCase(DeletarClienteAdapter deletarClienteAdapter){
        return new DeletarClienteUseCase(deletarClienteAdapter);
    }
}
