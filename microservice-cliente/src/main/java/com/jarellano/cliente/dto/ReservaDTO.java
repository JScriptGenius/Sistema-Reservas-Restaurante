package com.jarellano.cliente.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservaDTO {
    private Long idReserva;
    private LocalDate fecha;
    private String hora;
    private Long idMesa;
    private Long idCliente;
    private String estado;
}
