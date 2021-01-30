package com.devel.stillcareBackend;

import com.devel.stillcareBackend.model.TabletteEntity;
import com.devel.stillcareBackend.services.TabletteService;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.DataAccessException;

import java.util.Arrays;

@SpringBootApplication
@Configuration
@PropertySource("encrypted.properties")
@EncryptablePropertySource("encrypted.properties")
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


		//Test transaction rollback (duplicated key)

		try {
			tabletteService.add(new TabletteEntity(77, "Bulb"));
			tabletteService.add(new TabletteEntity(142, "Dijone mustard"));

			System.out.println("listAll: " + tabletteService.listAll());

			tabletteService.addAll(Arrays.asList(new TabletteEntity(55, "Book"), new TabletteEntity(44, "Soap"), new TabletteEntity(99, "Computer")));
		} catch (DataAccessException dataAccessException) {
			System.out.println("EXCEPTION OCCURED");
		}

		//Test element list after rollback
		System.out.println("listAll: " + tabletteService.listAll());

	}
}
