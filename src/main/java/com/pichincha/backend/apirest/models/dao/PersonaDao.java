/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pichincha.backend.apirest.models.dao;

import com.pichincha.backend.apirest.models.entity.Cliente;
import com.pichincha.backend.apirest.models.entity.ClientePK;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author user
 */
public interface PersonaDao extends JpaRepository<Cliente, ClientePK> {

    //Cliente findByIdPersonaAndIdCliente(Long idPersona, Long idCliente);
     List<Cliente> findByClientePKIdPersona(Long idPersona);
     
       @Query("select c FROM CompanyUserDetail c WHERE c.companyUserKey.companyId = :companyId")
      List<Cliente> findByCompanyId(@Param("companyId") UUID companyId);

}
