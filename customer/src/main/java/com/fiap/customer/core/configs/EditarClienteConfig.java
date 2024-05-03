package com.fiap.customer.core.configs;

import com.fiap.customer.core.usecase.EditarClienteUseCase;
import com.fiap.customer.infraestructure.adapters.EditarClienteAdapter;
import com.fiap.customer.infraestructure.api.mappers.ClienteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EditarClienteConfig {
    @Bean
    public EditarClienteUseCase editarClienteUseCase(EditarClienteAdapter editarClienteAdapter, ClienteMapper clienteMapper){
        return new EditarClienteUseCase(editarClienteAdapter, clienteMapper);
    }
}
