package com.fiap.customer.infraestructure.api.controllers;

import com.fiap.customer.core.ports.in.BuscarClienteInputPort;
import com.fiap.customer.core.ports.in.DeletarClienteInputPort;
import com.fiap.customer.core.ports.in.EditarClienteInputport;
import com.fiap.customer.core.ports.in.SalvarClienteInputport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class ClienteControllerTest {
    AutoCloseable openMocks;
    ClienteController controller;
    @Mock
    private  SalvarClienteInputport salvarClienteInputport;
    @Mock
    private  EditarClienteInputport editarClienteInputport;
    @Mock
    private  BuscarClienteInputPort buscarClienteInputPort;
    @Mock
    private  DeletarClienteInputPort deletarClienteInputPort;
    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
    }
    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }
    @Test
    void salvar() {
    }

    @Test
    void editar() {
    }

    @Test
    void buscar() {
    }

    @Test
    void deletar() {
    }
}