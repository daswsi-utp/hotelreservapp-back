package com.hotel.reservas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class ReservasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservasApplication.class, args);
	}

}
