package com.jarellano.mesa.service;

import com.jarellano.mesa.client.ReservaClient;
import com.jarellano.mesa.dto.ReservaDTO;
import com.jarellano.mesa.entity.Mesa;
import com.jarellano.mesa.http.response.ReservasByIdMesaResponse;
import com.jarellano.mesa.persistence.IMesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesaServiceImpl implements IMesaService {

    @Autowired
    private IMesaRepository mesaRepository;

    @Autowired
    private ReservaClient reservaClient;

    @Override
    public List<Mesa> obtenerTodasLasMesas() {
        return mesaRepository.findAll();
    }

    @Override
    public Optional<Mesa> obtenerMesaPorId(Long idMesa) {
        return mesaRepository.findById(idMesa);
    }

    @Override
    public void registrarMesa(Mesa mesa) {
        mesaRepository.save(mesa);
    }

    @Override
    public void actualizarMesa(Long idMesa, Mesa mesa) {
        Mesa mesaBD = obtenerMesaPorId(idMesa).get();
        mesaBD.setCapacidad(mesa.getCapacidad());
        mesaBD.setNumero(mesa.getNumero());
        mesaRepository.save(mesa);
    }

    @Override
    public void eliminarMesa(Long idMesa) {
        mesaRepository.deleteById(idMesa);
    }

    @Override
    public void actualizarEstadoMesa(String estado, Long idMesa) {
        mesaRepository.actualizarEstadoMesa(estado, idMesa);
    }

    @Override
    public ReservasByIdMesaResponse findAllReservasByIdMesa(Long idMesa) {
        Mesa mesa = obtenerMesaPorId(idMesa).orElse(new Mesa());

        List<ReservaDTO> reservaDTOList = reservaClient.findAllReservasByIdMesa(idMesa);

        return ReservasByIdMesaResponse.builder()
                .numero(mesa.getNumero())
                .capacidad(mesa.getCapacidad())
                .estado(mesa.getEstado())
                .reservaDTOList(reservaDTOList)
                .build();
    }
}
