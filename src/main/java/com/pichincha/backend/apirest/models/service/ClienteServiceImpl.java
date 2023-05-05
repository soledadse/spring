package com.pichincha.backend.apirest.models.service;

import com.pichincha.backend.apirest.models.dao.ClienteDao;
import com.pichincha.backend.apirest.models.dao.PersonaDao;
import com.pichincha.backend.apirest.models.entity.Cliente;
import com.pichincha.backend.apirest.models.entity.ClientePK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService {
    @Autowired
    private ClienteDao clienteDao;
    @Autowired
    private PersonaDao personaDao;
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cliente> findById(ClientePK id) {
        //return clienteDao.findById(id).orElse(null);
        return  personaDao.findById(id);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
        
    }

    @Override
    @Transactional
    public boolean delete(ClientePK id) {
        clienteDao.deleteById(id);
       
        return true;
    }

    @Override
    @Transactional
    public List<Cliente> findByClientePKIdPersona(Long idPersona) {
       return  personaDao.findByClientePKIdPersona(idPersona);
    }

   
}
