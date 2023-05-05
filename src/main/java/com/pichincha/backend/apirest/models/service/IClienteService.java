package com.pichincha.backend.apirest.models.service;

import com.pichincha.backend.apirest.models.entity.Cliente;
import com.pichincha.backend.apirest.models.entity.ClientePK;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    List<Cliente> findAll();
    Optional<Cliente> findById(ClientePK id);
    Cliente save(Cliente cliente);
    //Cliente findByIdPersonaAndIdCliente(Long idPersona, Long idCliente);
    boolean delete(ClientePK id);
    List<Cliente> findByClientePKIdPersona(Long idPersona);
}
