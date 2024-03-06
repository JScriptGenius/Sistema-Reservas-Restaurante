package com.jarellano.reserva.persistence;

import com.jarellano.reserva.entity.Reserva;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Reserva r SET r.estado = :estado WHERE r.idReserva = :idReserva")
    void actualizarEstadoReserva(@Param("idReserva") Long idReserva, @Param("estado") String estado);

    @Query("SELECT r FROM Reserva r WHERE r.idReserva = :idCliente")
    List<Reserva> findAllReservasByIdCLiente(@Param("idCliente") Long idCliente);

    @Query("SELECT r FROM Reserva r WHERE r.idReserva = :idMesa")
    List<Reserva> findAllReservasByIdMesa(@Param("idMesa") Long idMesa);

    @Query(
            value = "SELECT * FROM tbl_reservas WHERE DATE(fecha) = DATE(:fecha)",
            nativeQuery = true
    )
    List<Reserva> obtenerTodasLasReservasDeHoy(@Param("fecha") LocalDate fecha);
}
