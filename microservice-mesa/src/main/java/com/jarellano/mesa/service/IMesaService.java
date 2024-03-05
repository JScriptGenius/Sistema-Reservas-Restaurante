package com.jarellano.mesa.service;

import com.jarellano.mesa.entity.Mesa;
import com.jarellano.mesa.http.response.ReservasByIdMesaResponse;

import java.util.List;
import java.util.Optional;

public interface IMesaService {
    List<Mesa> obtenerTodasLasMesas();

    Optional<Mesa> obtenerMesaPorId(Long idMesa);

    void registrarMesa(Mesa mesa);

    void actualizarMesa(Long idMesa, Mesa mesa);

    void eliminarMesa(Long idMesa);

    void actualizarEstadoMesa(String estado, Long idMesa);

    ReservasByIdMesaResponse findAllReservasByIdMesa(Long idMesa);
}