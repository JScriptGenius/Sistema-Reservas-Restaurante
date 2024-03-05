package com.jarellano.mesa.http.response;

import com.jarellano.mesa.dto.ReservaDTO;
import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservasByIdMesaResponse {
    private String numero;
    private int capacidad;
    private String estado;
    List<ReservaDTO> reservaDTOList;
}
