package com.pichincha.backend.apirest.controllers;


import com.pichincha.backend.apirest.models.entity.Cliente;
import com.pichincha.backend.apirest.models.entity.ClientePK;
import com.pichincha.backend.apirest.models.entity.Persona;
import com.pichincha.backend.apirest.models.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private IClienteService clienteService;
    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> findAll() {
        return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/ver/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable("id")ClientePK id) {
        return new ResponseEntity<>(clienteService.findById(id), HttpStatus.OK);
    }
    @PostMapping("/guardar")
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
        Persona persona = new Persona();
        persona.setIdentificacion(cliente.getIdentificacion());
        persona.setNombre(cliente.getNombre());
        persona.setGenero(cliente.getGenero());
        persona.setEdad(cliente.getEdad());
        persona.setDireccion(cliente.getDireccion());
        persona.setTelefono(cliente.getTelefono());

        ClientePK pk = new ClientePK();
        pk.setIdCliente(cliente.getId() != null ? cliente.getId().getIdCliente() : null);
        pk.setIdPersona(cliente.getId() != null ? cliente.getId().getIdPersona() : null);

        cliente.setId(pk);
        cliente.setContrasena(cliente.getContrasena());
        cliente.setEstado(true);

        return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.CREATED);
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente, @PathVariable("id") ClientePK id) {
        Cliente clienteActual = clienteService.findById(id);
        clienteActual.setIdentificacion(cliente.getIdentificacion());
        clienteActual.setNombre(cliente.getNombre());
        clienteActual.setGenero(cliente.getGenero());
        clienteActual.setEdad(cliente.getEdad());
        clienteActual.setDireccion(cliente.getDireccion());
        clienteActual.setTelefono(cliente.getTelefono());
        clienteActual.setContrasena(cliente.getContrasena());
        clienteActual.setEstado(cliente.getEstado());
        return new ResponseEntity<>(clienteService.save(clienteActual), HttpStatus.CREATED);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity delete(@PathVariable("id") ClientePK id) {
        if (clienteService.delete(id)) {
            return new ResponseEntity("Cliente eliminado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity("No se pudo encontrar el cliente", HttpStatus.NOT_FOUND);
        }
    }
}
