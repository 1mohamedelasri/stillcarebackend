package com.devel.stillcareBackend.configuration;

import com.devel.stillcareBackend.model.TabletteEntity;
import com.devel.stillcareBackend.repositories.AffectationPersonnelRepository;
import com.devel.stillcareBackend.repositories.TabletteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(TabletteRepository repository, AffectationPersonnelRepository affectationRepository) {

        return args -> {
            TabletteEntity tab1 = new TabletteEntity();
            tab1.setNtablette(1);
            tab1.setEtat("AVAILABLE");
            TabletteEntity tab2 = new TabletteEntity();
            tab2.setNtablette(2);
            tab2.setEtat("Pending");
            log.info("Preloading " + repository.save(tab1));
            log.info("Preloading " + repository.save(tab2));
            //log.info("Preloading " + affectationRepository.save(new AffectationEntity(2,3, new Time(java.util.Calendar.getInstance().getTime().getTime()))));

        };
    }

}
