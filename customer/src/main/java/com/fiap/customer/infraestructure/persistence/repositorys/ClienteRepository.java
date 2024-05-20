package com.fiap.customer.infraestructure.persistence.repositorys;

import com.fiap.customer.infraestructure.persistence.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, String>{
}
