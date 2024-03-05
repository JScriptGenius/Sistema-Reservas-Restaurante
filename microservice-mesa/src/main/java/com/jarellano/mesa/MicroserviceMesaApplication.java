package com.jarellano.mesa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceMesaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceMesaApplication.class, args);
	}

}
