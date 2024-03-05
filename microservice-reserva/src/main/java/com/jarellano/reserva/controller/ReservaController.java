package com.jarellano.reserva.controller;

import com.jarellano.reserva.entity.Reserva;
import com.jarellano.reserva.service.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/reserva")
public class ReservaController {

    @Autowired
    private IReservaService reservaService;

    @PostMapping("/generate")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveReserva(@RequestBody Reserva reserva) {
        reservaService.generarReserva(reserva);
    }

    @GetMapping("/actualizarEstado/{idReserva}")
    public ResponseEntity<?> updateEstadoReserva(@PathVariable Long idReserva, @RequestParam String estado) {
        reservaService.actualizarEstadoReserva(idReserva, estado);
        return ResponseEntity.ok("¡Estado de reserva actualizado!");
    }

    @PutMapping("/editarInfoReserva/{idReserva}")
    public ResponseEntity<?> editarInformacionReserva(@PathVariable Long idReserva, @RequestBody Reserva reserva) {
        reservaService.editarReserva(idReserva, reserva);
        return ResponseEntity.ok("¡Reserva actualizada!");
    }

    @DeleteMapping("/cancelar/{idReserva}")
    public ResponseEntity<?> cancelarReserva(@PathVariable Long idReserva) {
        reservaService.cancelarReserva(idReserva);
        return ResponseEntity.ok("¡Reserva Cancelada!");
    }

    @GetMapping("/todasReservas")
    public ResponseEntity<?> findAllReservas() {
        return ResponseEntity.ok(reservaService.obtenerTodasLasReservas());
    }

    @GetMapping("/buscar/{idReserva}")
    public ResponseEntity<?> findById(@PathVariable Long idReserva) {
        return ResponseEntity.ok(reservaService.buscarReservaPorId(idReserva).orElseThrow());
    }

    @GetMapping("/buscar-por-cliente/{idCliente}")
    public ResponseEntity<?> findAllReservasByIdCliente(@PathVariable Long idCliente) {
        return ResponseEntity.ok(reservaService.buscarReservasPorIdCliente(idCliente));
    }

    @GetMapping("/buscar-por-mesa/{idMesa}")
    public ResponseEntity<?> findAllReservasByIdMesa(@PathVariable Long idMesa) {
        return ResponseEntity.ok(reservaService.buscarReservasPorIdMesa(idMesa));
    }

    @GetMapping("/hoy")
    public ResponseEntity<?> obtenerTodasLasReservasDeHoy() {
        LocalDate fechaActual = LocalDate.now();
        return ResponseEntity.ok(reservaService.obtenerTodasLasReservasDeHoy(fechaActual));
    }
}
