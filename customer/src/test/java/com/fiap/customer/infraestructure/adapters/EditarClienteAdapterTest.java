package com.fiap.customer.infraestructure.adapters;

import com.fiap.customer.core.domains.entities.ClienteDTO;
import com.fiap.customer.core.domains.exception.ClienteNaoEncontradoException;
import com.fiap.customer.infraestructure.persistence.entities.ClienteEntity;
import com.fiap.customer.infraestructure.persistence.repositorys.ClienteRepository;
import com.fiap.customer.infraestructure.utils.mappers.ClienteMapper;
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

class EditarClienteAdapterTest {

    AutoCloseable openMocks;
    @InjectMocks
    EditarClienteAdapter editarClienteAdapter;
    @Mock
    ClienteRepository clienteRepository;
    @Mock
    ClienteEntity clienteEntity;
    @Mock
    ClienteMapper clienteMapper;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
    }
    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    public void deveTestarEditarCliente(){

        var cpf     = "545.464.180-43";
        var email   = "teste@gmail.com";
        var nome    = "Teste Souza Silva";

        ClienteDTO clienteDTO = new ClienteDTO(cpf, email, nome);

        when(clienteRepository.findById(any(String.class))).thenReturn(Optional.of(clienteEntity));
        when(clienteMapper.toClienteEntity(any(ClienteDTO.class))).thenReturn(clienteEntity);

        editarClienteAdapter.editar(clienteDTO);

        verify(clienteRepository, times(1)).findById(any(String.class));
        verify(clienteRepository, times(1)).save(any(ClienteEntity.class));
    }

    @Test
    public void deveDispararExceptionAoTestarEditarCliente(){

        var cpf     = "545.464.180-43";
        var email   = "teste@gmail.com";
        var nome    = "Teste Souza Silva";

        ClienteDTO clienteDTO = new ClienteDTO(cpf, email, nome);

        when(clienteRepository.findById(any(String.class))).thenReturn(Optional.empty());

        ClienteNaoEncontradoException erro = assertThrows(ClienteNaoEncontradoException.class, ()-> editarClienteAdapter.editar(clienteDTO));

        assertNotNull(erro);
        assertTrue(erro.getMessage().contains("Cliente não encontrado!"));
    }
}