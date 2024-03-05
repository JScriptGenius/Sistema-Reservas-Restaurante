package com.jarellano.reserva.service;

import com.jarellano.reserva.entity.Reserva;

import java.time.LocalDateTime;
import java.util.List;

public interface IReservaService {
    Reserva generarReserva(Reserva reserva);
    void actualizarEstadoReserva(Long idReserva, String estado);
    void editarReserva(Long idReserva, LocalDateTime nuevaFecha);
    void cancelarReserva(Long idReserva);
    List<Reserva> obtenerTodasLasReservas();
    Reserva buscarReservaPorId(Long idReserva);
    List<Reserva> buscarReservaPorIdCliente(Long idCliente);
    List<Reserva> buscarReservaPorIdMesa(Long idMesa);
    List<Reserva> obtenerReservaPorFechaYHora(LocalDateTime fechaInicio, LocalDateTime fechaFin);
}
