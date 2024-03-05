package com.jarellano.cliente.http.response;


import com.jarellano.cliente.dto.ReservaDTO;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservasByIdClienteResponse {
    private String nombreCliente;
    private String apellidoCliente;
    private String emailCliente;
    private List<ReservaDTO> reservaDTOList;
}
