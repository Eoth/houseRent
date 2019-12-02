package com.Projet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"Controller, Service, SecurityConfig"})
@EntityScan("estateProduct")
@EnableJpaRepositories("Repository")
public class HouseRentApplication {

	public static void main(String[] args) {
		SpringApplication.run(HouseRentApplication.class, args);
	}

}
