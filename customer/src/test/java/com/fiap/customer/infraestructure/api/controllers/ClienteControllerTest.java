package com.fiap.customer.infraestructure.api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.customer.core.ports.in.BuscarClienteInputPort;
import com.fiap.customer.core.ports.in.DeletarClienteInputPort;
import com.fiap.customer.core.ports.in.EditarClienteInputport;
import com.fiap.customer.core.ports.in.SalvarClienteInputport;
import com.fiap.customer.infraestructure.api.requests.ClienteRequest;
import com.fiap.customer.infraestructure.api.responses.ClienteResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.UriComponentsBuilder;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class ClienteControllerTest {
    AutoCloseable openMocks;
    @Mock
    private SalvarClienteInputport salvarClienteInputport;
    @Mock
    private  EditarClienteInputport editarClienteInputport;
    @Mock
    private  BuscarClienteInputPort buscarClienteInputPort;
    @Mock
    private  DeletarClienteInputPort deletarClienteInputPort;
    @Mock
    private MockMvc mockMvc;
    @Mock
    private ClienteRequest clienteRequest;
    @Mock
    ClienteResponse clienteResponse;
    @Mock
    UriComponentsBuilder uriComponentsBuilder;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
        ClienteController controller = new ClienteController(salvarClienteInputport, editarClienteInputport,
                buscarClienteInputPort, deletarClienteInputPort);
        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }
    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }
    @Test
    void salvar() throws Exception {

        doNothing().when(salvarClienteInputport).salvar(any(ClienteRequest.class));

        mockMvc.perform(post("/cliente")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(clienteRequest)))
                .andExpect(status().isCreated());

        verify(salvarClienteInputport, times(1)).salvar(any(ClienteRequest.class));

    }

    @Test
    void editar() throws Exception {

        doNothing().when(editarClienteInputport).editar(any(ClienteRequest.class));

        mockMvc.perform(patch("/cliente")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(clienteRequest)))
                    .andExpect(status().isOk());

        verify(editarClienteInputport, times(1)).editar(any(ClienteRequest.class));

    }

    @Test
    void buscar() throws Exception {
        String cpf = "476.724.180-41";
        when(buscarClienteInputPort.buscarCliente(any(String.class))).thenReturn(clienteResponse);

        mockMvc.perform(get("/cliente/{cpf}", cpf))
                    .andExpect(status().isOk());

        verify(buscarClienteInputPort, times(1)).buscarCliente(any(String.class));

    }

    @Test
    void deletar() throws Exception {

        String cpf = "476.724.180-41";
        doNothing().when(deletarClienteInputPort).deletar(cpf);

        mockMvc.perform(delete("/cliente/{cpf}", cpf))
                    .andExpect(status().isNoContent());

        verify(deletarClienteInputPort, times(1)).deletar(cpf);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}