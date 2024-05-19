package com.fiap.customer.infraestructure.adapters;

import com.fiap.customer.core.domains.exception.ClienteNaoEncontradoException;
import com.fiap.customer.infraestructure.persistence.entities.ClienteEntity;
import com.fiap.customer.infraestructure.persistence.repositorys.ClienteRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class DeletarClienteAdapterTest {

    AutoCloseable openMocks;
    @InjectMocks
    DeletarClienteAdapter deletarClienteAdapter;
    @Mock
    ClienteRepository clienteRepository;
    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @Test
    public void deveTestarDeletarClienteAdapter(){

        var cpf = "545.464.180-43";
        ClienteEntity cliente = new ClienteEntity();

        when(clienteRepository.findById(cpf)).thenReturn(Optional.of(cliente));

        deletarClienteAdapter.deletar(cpf);

        verify(clienteRepository,times(1)).findById(cpf);
        verify(clienteRepository,times(1)).deleteById(cpf);

    }

    @Test
    public void deveLancarExceptionClienteNaoEncontradoaoDeletarClienteAdapter(){

        when(clienteRepository.findById(any(String.class))).thenReturn(Optional.empty());

        ClienteNaoEncontradoException erro = assertThrows(ClienteNaoEncontradoException.class, ()-> deletarClienteAdapter.deletar(any(String.class)));

        assertNotNull(erro);
        assertTrue(erro.getMessage().contains("Cliente não encontrado!"));
    }
}