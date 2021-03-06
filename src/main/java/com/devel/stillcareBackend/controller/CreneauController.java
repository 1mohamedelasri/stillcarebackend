package com.devel.stillcareBackend.controller;

import com.devel.stillcareBackend.exception.exceptionmodels.BadParametersException;
import com.devel.stillcareBackend.exception.exceptionmodels.NotFoundException;
import com.devel.stillcareBackend.model.CreneauEntity;
import com.devel.stillcareBackend.model.CreneauEntityPK;
import com.devel.stillcareBackend.repositories.CreneauRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class CreneauController {

    private final CreneauRepository repository;

    CreneauController(CreneauRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/creneaux")
    List<CreneauEntity> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/creneaux")
    CreneauEntity newCreneau(@RequestBody CreneauEntity newCreneau) {
        return repository.save(newCreneau);
    }


    @PostMapping("/creneaux/list")
    List<CreneauEntity> newMultiCreneau(@RequestBody List<CreneauEntity> newCreneau) {
        if(newCreneau == null) throw new BadParametersException(newCreneau.toString());
        return repository.saveAll(newCreneau);
    }

    // Single item

    @GetMapping("/creneaux/{data}/{personnel}")
    CreneauEntity one(@RequestParam("localDate")
                       @DateTimeFormat(pattern = "yyyy-MM-dd hh mm ss") Date localDate,
                      @PathVariable Long personnel) {
        CreneauEntityPK creneauPK = new CreneauEntityPK();
        creneauPK.setIdPersonnel(personnel);
        creneauPK.setDatedebut(localDate);

        return repository.findById(creneauPK)
                .orElseThrow(() -> new NotFoundException("Creneau de la date"+creneauPK.getDatedebut() + "avec le personnel" + creneauPK.getIdPersonnel()));
    }


    @PutMapping("/creneaux/{data}/{personnel}")
    CreneauEntity replaceCreneau(@RequestBody CreneauEntity newCreneau,
                                  @RequestParam("localDate")
                                   @DateTimeFormat(pattern = "yyyy-MM-dd hh mm ss") Date localDate,
                                  @PathVariable Long personnel) {
        CreneauEntityPK creneauPK = new CreneauEntityPK();
        creneauPK.setIdPersonnel(personnel);
        creneauPK.setDatedebut(localDate);

        return repository.findById(creneauPK)
                .map(creneau -> {
                    creneau.setIdPersonnel(newCreneau.getIdPersonnel());
                    creneau.setDatedebut(newCreneau.getDatedebut());
                    creneau.setEtat(newCreneau.getEtat());

                    return repository.save(creneau);
                })
                .orElseGet(() -> {
                    newCreneau.setDatedebut(localDate);
                    newCreneau.setIdPersonnel(personnel);
                    return repository.save(newCreneau);
                });
    }

    @DeleteMapping("/creneaux/{data}/{personnel}")
    void deleteCreneau(@RequestParam("localDate")
                        @DateTimeFormat(pattern = "yyyy-MM-dd hh mm ss") Date localDate,
                        @PathVariable Long personnel) {
        CreneauEntityPK creneauPK = new CreneauEntityPK();
        creneauPK.setIdPersonnel(personnel);
        creneauPK.setDatedebut(localDate);
        repository.deleteById(creneauPK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/creneaux/personnel/sansRdv/{id}")
    List<CreneauEntity> getCreneauByPersonnel(@PathVariable Long id) {
        return repository.CreneauSansRdv(id);
    }

    @GetMapping("/creneaux/resident/libre/{id}")
    List<CreneauEntity> getCreneauByResident(@PathVariable Long id) {
        return repository.CreneauLibreResident(id);
    }



}
