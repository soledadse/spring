package com.pichincha.backend.apirest.models.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class ClientePK implements Serializable {

    // PK Clase Persona
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_seq")
    @SequenceGenerator(name = "persona_seq", sequenceName = "personas_id_seq", allocationSize = 1)
    @Column(name = "id_persona")
    private Long idPersona;
    // PK Entidad: Cliente (Linkedln: paulabadt)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
    @SequenceGenerator(name = "cliente_seq", sequenceName = "clientes_id_seq", allocationSize = 1)
    @Column(name = "id_cliente")
    private Long idCliente;

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "ClientePK{" + "idPersona=" + idPersona + ", idCliente=" + idCliente + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ClientePK that = (ClientePK) o;

        if (!idCliente.equals(that.idCliente)) {
            return false;
        }
        return idPersona.equals(that.idPersona);
    }

    @Override
    public int hashCode() {
        int result = idPersona.hashCode();
        result = 31 * result + idCliente.hashCode();
        return result;
    }

}
