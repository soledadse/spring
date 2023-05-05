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
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> findAll() {
        return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/listarByIdPersona/{idPersona}")
    public ResponseEntity<List<Cliente>> findAllByIdPersona(@PathVariable("idPersona") Long idPersona) {
        return new ResponseEntity<>(clienteService.findByClientePKIdPersona(idPersona), HttpStatus.OK);
    }

    /* @GetMapping("/ver/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable("id")ClientePK id) {
        return new ResponseEntity<>(clienteService.findById(id), HttpStatus.OK);
    }*/
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
        System.out.println("clienteID:" + cliente.getClientePK());
        pk.setIdCliente(cliente.getClientePK() != null ? cliente.getClientePK().getIdCliente() : null);
        pk.setIdPersona(cliente.getClientePK() != null ? cliente.getClientePK().getIdPersona() : null);

        System.out.println("pk:" + pk.toString());
        cliente.setClientePK(pk);
        cliente.setContrasena(cliente.getContrasena());
        cliente.setEstado(true);

        return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{idPersona}/{idCliente}")
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente, @PathVariable("idPersona") Long idPersona, @PathVariable("idCliente") Long idCliente) {
        ClientePK pk = new ClientePK();
        pk.setIdCliente(idCliente);
        pk.setIdPersona(idPersona);
        Optional<Cliente> opc = clienteService.findById(pk);
        Cliente client = new Cliente();

        return opc
                .map(clienteActual -> {
                   
                    clienteActual.setIdentificacion(cliente.getIdentificacion());
                    clienteActual.setNombre(cliente.getNombre());
                    clienteActual.setGenero(cliente.getGenero());
                    clienteActual.setEdad(cliente.getEdad());
                    clienteActual.setDireccion(cliente.getDireccion());
                    clienteActual.setTelefono(cliente.getTelefono());
                    clienteActual.setContrasena(cliente.getContrasena());
                    clienteActual.setEstado(cliente.getEstado());

                    clienteService.save(client);
                    return new ResponseEntity<>(clienteService.save(client), HttpStatus.CREATED);
                })
                .orElse(new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping("/borrar/{idPersona}/{idCliente}")
    public ResponseEntity delete(@PathVariable("idPersona") Long idPersona, @PathVariable("idCliente") Long idCliente) {
         ClientePK pk = new ClientePK();
        pk.setIdCliente(idCliente);
        pk.setIdPersona(idPersona);
        if (clienteService.delete(pk)) {
            return new ResponseEntity("Cliente eliminado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity("No se pudo encontrar el cliente", HttpStatus.NOT_FOUND);
        }
    }
}
