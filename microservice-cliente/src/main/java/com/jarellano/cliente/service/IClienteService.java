package com.jarellano.cliente.service;

import com.jarellano.cliente.entity.Cliente;
import com.jarellano.cliente.http.response.ReservasByIdClienteResponse;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    void guardarCliente(Cliente cliente);
    void actualizarCliente(Long idCliente, Cliente cliente);
    void eliminarCliente(Long idCliente);
    Optional<Cliente> buscarClientePorId(Long idCliente);
    List<Cliente> obtenerTodosLosClientes();
    ReservasByIdClienteResponse findAllReservasByIdCliente(Long idCliente);
}
