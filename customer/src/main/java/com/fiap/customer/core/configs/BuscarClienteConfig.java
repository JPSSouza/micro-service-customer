package com.fiap.customer.core.configs;

import com.fiap.customer.core.usecase.BuscarClienteUseCase;
import com.fiap.customer.infraestructure.adapters.BuscarClienteAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarClienteConfig {

    @Bean
    public BuscarClienteUseCase buscarClienteUseCase(BuscarClienteAdapter buscarClienteAdapter){
        return new BuscarClienteUseCase(buscarClienteAdapter);
    };

}


