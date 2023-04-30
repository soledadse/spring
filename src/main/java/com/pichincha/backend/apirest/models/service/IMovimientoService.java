package com.pichincha.backend.apirest.models.service;

import com.pichincha.backend.apirest.models.entity.Movimiento;

import java.util.List;

public interface IMovimientoService {
    List<Movimiento> findAll();
    Movimiento findById(Long movimientoid);
}
