package com.devel.stillcareBackend.configuration;

import com.devel.stillcareBackend.model.TabletteEntity;
import com.devel.stillcareBackend.respository.TabletteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(TabletteRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new TabletteEntity(1, "Running")));
            log.info("Preloading " + repository.save(new TabletteEntity(2, "Pending")));
        };
    }

}
