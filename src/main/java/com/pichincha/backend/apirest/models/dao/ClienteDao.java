package com.pichincha.backend.apirest.models.dao;

import com.pichincha.backend.apirest.models.entity.Cliente;
import com.pichincha.backend.apirest.models.entity.ClientePK;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, ClientePK> {
    
}
