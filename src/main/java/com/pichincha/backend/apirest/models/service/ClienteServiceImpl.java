package com.pichincha.backend.apirest.models.service;

import com.pichincha.backend.apirest.models.dao.ClienteDao;
import com.pichincha.backend.apirest.models.entity.Cliente;
import com.pichincha.backend.apirest.models.entity.ClientePK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {
    @Autowired
    private ClienteDao clienteDao;
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(ClientePK id) {
        return clienteDao.findById(id).orElse(null);
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
        return false;
    }
}
