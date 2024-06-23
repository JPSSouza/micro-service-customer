package com.fiap.customer.infraestructure.api.responses;

import org.junit.jupiter.api.Test;
import utils.BeanGettersAndSettersTester;
import java.beans.IntrospectionException;
class ClienteResponseTest {
    @Test
    public void deveteTestarClienteResponseTest() throws IntrospectionException {
        BeanGettersAndSettersTester.test(ClienteResponse.class);
    }

}