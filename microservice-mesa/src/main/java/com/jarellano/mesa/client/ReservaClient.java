package com.jarellano.mesa.client;

import com.jarellano.mesa.dto.ReservaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@FeignClient(
        name = "msvc-reserva",
        url = "localhost:8090/api/reserva"
)
public interface ReservaClient {

    @GetMapping("/buscar-por-mesa/{idMesa}")
    List<ReservaDTO> findAllReservasByIdMesa(@PathVariable Long idMesa);
}
