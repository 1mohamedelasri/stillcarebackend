package com.devel.stillcareBackend.controller;

import com.devel.stillcareBackend.exception.exceptionmodels.NotFoundException;
import com.devel.stillcareBackend.model.EphadEntity;
import com.devel.stillcareBackend.repositories.EphadRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EphadController {

    private final EphadRepository repository;

    EphadController(EphadRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/ephads")
    List<EphadEntity> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/ephads")
    EphadEntity newEphad(@RequestBody EphadEntity newEphad) {
        return repository.save(newEphad);
    }

    // Single item

    @GetMapping("/ephads/{id}")
    EphadEntity one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ephad with "+ id));
    }

    @PutMapping("/ephads/{id}")
    EphadEntity replaceEphad(@RequestBody EphadEntity newEphad, @PathVariable Long id) {

        return repository.findById(id)
                .map(Ephad -> {
                    Ephad.setNom(newEphad.getNom());
                    return repository.save(Ephad);
                })
                .orElseGet(() -> {
                    newEphad.setIdEphad(id);
                    return repository.save(newEphad);
                });
    }

    @DeleteMapping("/ephads/{id}")
    void deleteEphad(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
