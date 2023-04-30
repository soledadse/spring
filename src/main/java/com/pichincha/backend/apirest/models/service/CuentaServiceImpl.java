package com.pichincha.backend.apirest.models.service;

import com.pichincha.backend.apirest.models.dao.CuentaDao;
import com.pichincha.backend.apirest.models.entity.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CuentaServiceImpl implements ICuentaService{
    @Autowired
    private CuentaDao cuentaDao;
    @Override
    @Transactional(readOnly = true)
    public List<Cuenta> findAll() {
        return (List<Cuenta>) cuentaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cuenta findById(Long numeroCuenta) {
        return cuentaDao.findById(numeroCuenta).orElse(null);
    }
}
