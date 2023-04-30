package com.pichincha.backend.apirest.models.dao;

import com.pichincha.backend.apirest.models.entity.Cuenta;
import org.springframework.data.repository.CrudRepository;

public interface CuentaDao extends CrudRepository<Cuenta, Long> {
}
