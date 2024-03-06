package com.jarellano.mesa.controller;

import com.jarellano.mesa.entity.Mesa;
import com.jarellano.mesa.service.IMesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mesa")
public class MesaController {

    @Autowired
    private IMesaService mesaService;

    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public void guardarMesa(@RequestBody Mesa mesa) {
        mesaService.registrarMesa(mesa);
    }

    @GetMapping("/todos")
    public ResponseEntity<?> obtenerTodasLasMesas() {
        return ResponseEntity.ok(mesaService.obtenerTodasLasMesas());
    }

    @GetMapping("/buscar/{idMesa}")
    public ResponseEntity<?> obtenerMesaPorId(@PathVariable Long idMesa) {
        return ResponseEntity.ok(mesaService.obtenerMesaPorId(idMesa));
    }

    @PutMapping("/actualizar/{idMesa}")
    public ResponseEntity<?> actualizarInformacionDeLaMesa(@PathVariable Long idMesa, @RequestBody Mesa mesa) {
        mesaService.actualizarMesa(idMesa, mesa);
        return ResponseEntity.ok("¡Mesa actualizada!");
    }

    @DeleteMapping("/eliminar/{idMesa}")
    public ResponseEntity<?> eliminarClientePorId(@PathVariable Long idMesa) {
        mesaService.eliminarMesa(idMesa);
        return ResponseEntity.ok("¡Mesa eliminada!");
    }

    @GetMapping("/actulaizarEstado/{idMesa}")
    public ResponseEntity<?> actualizarEstadoMesa(@PathVariable Long idMesa, @RequestParam String estado) {
        mesaService.actualizarEstadoMesa(estado, idMesa);
        return ResponseEntity.ok("¡Estado de mesa Actualizado!");
    }

    @GetMapping("/buscar-reservas-por-Mesa/{idMesa}")
    public ResponseEntity<?> findAllReservasByMesaId(@PathVariable Long idMesa) {
        return ResponseEntity.ok(mesaService.findAllReservasByIdMesa(idMesa));
    }
}