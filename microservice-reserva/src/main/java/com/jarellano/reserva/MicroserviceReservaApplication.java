package com.jarellano.reserva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceReservaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceReservaApplication.class, args);
	}

}
