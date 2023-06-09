package com.coyotwilly.nomad.Nomad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class NomadApplication {

	public static void main(String[] args) {
		SpringApplication.run(NomadApplication.class, args);
	}

}
