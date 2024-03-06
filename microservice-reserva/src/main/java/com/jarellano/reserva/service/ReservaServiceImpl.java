package com.jarellano.reserva.service;

import com.jarellano.reserva.entity.Reserva;
import com.jarellano.reserva.persistence.IReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements IReservaService {

    @Autowired
    private IReservaRepository reservaRepository;

    @Override
    public Reserva generarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }


    @Override
    public void actualizarEstadoReserva(Long idReserva, String estado) {
        if (idReserva != null) {
            reservaRepository.actualizarEstadoReserva(idReserva, estado);
        }
    }

    @Override
    public void editarReserva(Long idReserva, Reserva reserva) {
        Reserva reservaBD = reservaRepository.findById(idReserva).orElseThrow();
        if (reservaBD != null) {
            reservaBD.setFecha(reserva.getFecha());
            reservaBD.setHora(reserva.getHora());
            reservaRepository.save(reservaBD);
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
    public Optional<Reserva> buscarReservaPorId(Long idReserva) {
        return reservaRepository.findById(idReserva);
    }

    @Override
    public List<Reserva> buscarReservasPorIdCliente(Long idCliente) {
        return reservaRepository.findAllReservasByIdCLiente(idCliente);
    }

    @Override
    public List<Reserva> buscarReservasPorIdMesa(Long idMesa) {
        return reservaRepository.findAllReservasByIdMesa(idMesa);
    }

    @Override
    public List<Reserva> obtenerTodasLasReservasDeHoy(LocalDate fecha) {
        return reservaRepository.obtenerTodasLasReservasDeHoy(fecha);
    }
}