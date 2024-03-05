package com.jarellano.reserva.controller;

import com.jarellano.reserva.service.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reserva")
public class ReservaController {

    @Autowired
    private IReservaService reservaService;

}
