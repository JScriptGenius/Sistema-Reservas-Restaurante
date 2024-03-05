package com.jarellano.reserva.persistence;

import com.jarellano.reserva.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByIdCliente(Long idCliente);
    List<Reserva> findByIdMesa(Long idMesa);
    List<Reserva> findByFechaBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);
}
