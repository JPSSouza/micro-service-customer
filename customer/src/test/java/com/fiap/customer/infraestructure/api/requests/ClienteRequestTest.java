package com.fiap.customer.infraestructure.api.requests;

import org.junit.jupiter.api.Test;
import utils.BeanGettersAndSettersTester;

import java.beans.IntrospectionException;



class ClienteRequestTest {
    @Test
    void deveTestarClienteRequest() throws IntrospectionException {
        BeanGettersAndSettersTester.test(ClienteRequest.class);
    }
}