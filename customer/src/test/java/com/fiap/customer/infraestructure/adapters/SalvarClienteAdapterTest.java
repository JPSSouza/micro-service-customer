package com.fiap.customer.infraestructure.adapters;

import com.fiap.customer.core.domains.entities.ClienteDTO;
import com.fiap.customer.infraestructure.persistence.entities.ClienteEntity;

import com.fiap.customer.infraestructure.persistence.repositorys.ClienteRepository;
import com.fiap.customer.infraestructure.utils.mappers.ClienteMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SalvarClienteAdapterTest {

    AutoCloseable openMocks;
    @InjectMocks
    SalvarClienteAdapter salvarClienteAdapter;
    @Mock
    ClienteRepository clienteRepository;
    @Mock
    ClienteMapper clienteMapper;
    @Mock
    ClienteDTO clienteDTO;
    @Mock
    ClienteEntity clienteEntity;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
    }
    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    public void deveTestarSalvarCliente(){


        when(clienteRepository.save(any(ClienteEntity.class))).thenReturn(clienteEntity);
        when(clienteMapper.toClienteEntity(any(ClienteDTO.class))).thenReturn(clienteEntity);

        salvarClienteAdapter.salvar(clienteDTO);

        verify(clienteMapper, times(1)).toClienteEntity(clienteDTO);
        verify(clienteRepository, times(1)).save(any(ClienteEntity.class));
    }
}