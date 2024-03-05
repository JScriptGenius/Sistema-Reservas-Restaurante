package com.jarellano.reserva.service;

import com.jarellano.reserva.entity.Reserva;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IReservaService {
    Reserva generarReserva(Reserva reserva);
    void actualizarEstadoReserva(Long idReserva, String estado);
    void editarReserva(Long idReserva, Reserva reserva);
    void cancelarReserva(Long idReserva);
    List<Reserva> obtenerTodasLasReservas();
    Optional<Reserva> buscarReservaPorId(Long idReserva);
    List<Reserva> buscarReservasPorIdCliente(Long idCliente);
    List<Reserva> buscarReservasPorIdMesa(Long idMesa);
    List<Reserva> obtenerTodasLasReservasDeHoy(LocalDate fecha);
}
