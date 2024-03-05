package com.jarellano.reserva.service;

import com.jarellano.reserva.entity.Reserva;
import com.jarellano.reserva.persistence.ReservaRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservaServiceImpl implements IReservaService {
    private final ReservaRepository reservaRepository;

    public ReservaServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    public Reserva generarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    public void actualizarEstadoReserva(Long idReserva, String estado) {
        Reserva reserva = reservaRepository.findById(idReserva).orElse(null);
        if (reserva != null) {
            reserva.setEstado(estado);
            reservaRepository.save(reserva);
        }
    }

    @Override
    public void editarReserva(Long idReserva, LocalDateTime nuevaFecha) {
        Reserva reserva = reservaRepository.findById(idReserva).orElse(null);
        if (reserva != null) {
            reserva.setFecha(nuevaFecha);
            reservaRepository.save(reserva);
        }
    }

    @Override
    public void cancelarReserva(Long idReserva) {
        reservaRepository.deleteById(idReserva);
    }

    @Override
    public List<Reserva> obtenerTodasLasReservas() {
        return reservaRepository.findAll();
    }

    @Override
    public Reserva buscarReservaPorId(Long idReserva) {
        return reservaRepository.findById(idReserva).orElse(null);
    }

    @Override
    public List<Reserva> buscarReservaPorIdCliente(Long idCliente) {
        return reservaRepository.findByIdCliente(idCliente);
    }

    @Override
    public List<Reserva> buscarReservaPorIdMesa(Long idMesa) {
        return reservaRepository.findByIdMesa(idMesa);
    }

    @Override
    public List<Reserva> obtenerReservaPorFechaYHora(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return reservaRepository.findByFechaBetween(fechaInicio, fechaFin);
    }
}