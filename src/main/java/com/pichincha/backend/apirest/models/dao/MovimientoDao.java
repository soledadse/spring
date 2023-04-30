package com.pichincha.backend.apirest.models.dao;

import com.pichincha.backend.apirest.models.entity.Movimiento;
import org.springframework.data.repository.CrudRepository;

public interface MovimientoDao extends CrudRepository<Movimiento, Long> {
}
