package com.fiap.customer.infraestructure.persistence.entities;

import org.junit.jupiter.api.Test;
import utils.BeanGettersAndSettersTester;
import java.beans.IntrospectionException;

class ClienteEntityTest {
    @Test
    public void deveTestarGetersAndSettersClientEntity() throws IntrospectionException {
        BeanGettersAndSettersTester.test(ClienteEntity.class);
    }
}