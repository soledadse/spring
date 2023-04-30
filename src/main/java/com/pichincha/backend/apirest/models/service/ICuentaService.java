package com.pichincha.backend.apirest.models.service;

import com.pichincha.backend.apirest.models.entity.Cuenta;

import java.util.List;

public interface ICuentaService {
    List<Cuenta> findAll();
    Cuenta findById(Long numeroCuenta);
}
