package com.pichincha.backend.apirest.models.service;

import com.pichincha.backend.apirest.models.dao.MovimientoDao;
import com.pichincha.backend.apirest.models.entity.Movimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovimientoServiceImpl implements IMovimientoService {
    @Autowired
    private MovimientoDao movimientoDao;
    @Override
    @Transactional(readOnly = true)
    public List<Movimiento> findAll() {
        return (List<Movimiento>) movimientoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Movimiento findById(Long movimientoid) {
        return movimientoDao.findById(movimientoid).orElse(null);
    }
}
