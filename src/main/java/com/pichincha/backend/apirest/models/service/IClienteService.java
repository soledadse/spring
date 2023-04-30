package com.pichincha.backend.apirest.models.service;

import com.pichincha.backend.apirest.models.entity.Cliente;
import com.pichincha.backend.apirest.models.entity.ClientePK;

import java.util.List;

public interface IClienteService {
    List<Cliente> findAll();
    Cliente findById(ClientePK id);
    Cliente save(Cliente cliente);
    boolean delete(ClientePK id);
}
