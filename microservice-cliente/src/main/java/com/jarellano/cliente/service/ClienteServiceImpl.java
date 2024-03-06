package com.jarellano.cliente.service;

import com.jarellano.cliente.client.ReservaClient;
import com.jarellano.cliente.dto.ReservaDTO;
import com.jarellano.cliente.entity.Cliente;
import com.jarellano.cliente.http.response.ReservasByIdClienteResponse;
import com.jarellano.cliente.persistence.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private ReservaClient reservaClient;

    @Override
    public void guardarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void actualizarCliente(Long idCliente, Cliente cliente) {
        Cliente clienteBD = buscarClientePorId(idCliente).get();
        clienteBD.setNombre(cliente.getNombre());
        clienteBD.setApellido(cliente.getApellido());
        clienteBD.setEmail(cliente.getEmail());
        clienteBD.setTelefono(cliente.getTelefono());
        clienteRepository.save(clienteBD);
    }

    @Override
    public void eliminarCliente(Long idCliente) {
        clienteRepository.deleteById(idCliente);
    }

    @Override
    public Optional<Cliente> buscarClientePorId(Long idCliente) {
        return clienteRepository.findById(idCliente);
    }

    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public ReservasByIdClienteResponse findAllReservasByIdCliente(Long idCliente) {
        Cliente cliente = buscarClientePorId(idCliente).orElse(new Cliente());

        List<ReservaDTO> reservaDTOList = reservaClient.findAllReservasByIdCliente(idCliente);
        return ReservasByIdClienteResponse.builder()
                .nombreCliente(cliente.getNombre())
                .apellidoCliente(cliente.getApellido())
                .emailCliente(cliente.getEmail())
                .reservaDTOList(reservaDTOList)
                .build();
    }
}
