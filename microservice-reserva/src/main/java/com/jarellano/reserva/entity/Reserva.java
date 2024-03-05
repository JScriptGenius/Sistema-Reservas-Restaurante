package com.jarellano.reserva.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
        name = "tbl_reservas"
)
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;
    private LocalDateTime fecha;

    @Column(name = "id_mesa")
    private Long idMesa;

    @Column(name = "id_cliente")
    private Long idCliente;

    private String estado;
}
