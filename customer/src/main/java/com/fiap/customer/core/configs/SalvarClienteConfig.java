package com.fiap.customer.core.configs;

import com.fiap.customer.core.usecase.SalvarClienteUseCase;
import com.fiap.customer.infraestructure.adapters.SalvarClienteAdapter;
import com.fiap.customer.infraestructure.utils.mappers.ClienteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalvarClienteConfig {
    @Bean
    public SalvarClienteUseCase salvarClienteUseCase(SalvarClienteAdapter salvarClienteAdapter, ClienteMapper clienteMapper)
    {
        return new SalvarClienteUseCase(salvarClienteAdapter, clienteMapper);
    }
}
