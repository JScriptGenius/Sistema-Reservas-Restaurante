package com.jarellano.cliente.controller;

import com.jarellano.cliente.entity.Cliente;
import com.jarellano.cliente.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public void guardarCliente(@RequestBody Cliente cliente) {
        clienteService.guardarCliente(cliente);
    }

    @GetMapping("/todos")
    public ResponseEntity<?> obtenerTodosClientes() {
        return ResponseEntity.ok(clienteService.obtenerTodosLosClientes());
    }

    @GetMapping("/buscar/{idCliente}")
    public ResponseEntity<?> obtenerClientePorId(@PathVariable Long idCliente) {
        return ResponseEntity.ok(clienteService.buscarClientePorId(idCliente));
    }

    @PutMapping("/actualizarInfo/{idCliente}")
    public ResponseEntity<?> actualizarInformacionCliente(@PathVariable Long idCliente, @RequestBody Cliente cliente) {
        clienteService.actualizarCliente(idCliente, cliente);
        return ResponseEntity.ok("¡Cliente actualizado!");
    }

    @DeleteMapping("/eliminar/{idCliente}")
    public ResponseEntity<?> eliminarClientePorId(@PathVariable Long idCliente) {
        clienteService.eliminarCliente(idCliente);
        return ResponseEntity.ok("¡Cliente eliminado!");
    }

    /*COMUNICACION DE MICROSERVICES*/
    @GetMapping("/buscar-reservas-por-cliente/{idCliente}")
    public ResponseEntity<?> findAllReservasByClienteId(@PathVariable Long idCliente) {
        return ResponseEntity.ok(clienteService.findAllReservasByIdCliente(idCliente));
    }
}
