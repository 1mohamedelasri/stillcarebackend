package com.devel.stillcareBackend;

import com.devel.stillcareBackend.services.TabletteService;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableEncryptableProperties
public class StillcareBackendApplication implements CommandLineRunner {

	@Autowired
	TabletteService tabletteService;


	public static void main(String[] args) {

		SpringApplication.run(StillcareBackendApplication.class, args);
		System.out.println("Introducing Barca player");





	}

	@Override
	public void run(String... arg0) throws Exception {

		//Do some data operation

	}
}
