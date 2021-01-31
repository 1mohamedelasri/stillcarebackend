package com.devel.stillcareBackend.configuration;

import com.devel.stillcareBackend.model.AffectationEntity;
import com.devel.stillcareBackend.model.TabletteEntity;
import com.devel.stillcareBackend.repositories.AffectationRepository;
import com.devel.stillcareBackend.repositories.TabletteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Time;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(TabletteRepository repository, AffectationRepository affectationRepository) {

        return args -> {
            log.info("Preloading " + repository.save(new TabletteEntity(1, "Running")));
            log.info("Preloading " + repository.save(new TabletteEntity(2, "Pending")));
            //log.info("Preloading " + affectationRepository.save(new AffectationEntity(2,3, new Time(java.util.Calendar.getInstance().getTime().getTime()))));

        };
    }

}
