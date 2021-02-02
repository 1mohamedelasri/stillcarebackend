package com.devel.stillcareBackend.controller;

import com.devel.stillcareBackend.exception.exceptionmodels.NotFoundException;
import com.devel.stillcareBackend.model.EhpadEntity;
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
    @GetMapping("/ehpads")
    List<EhpadEntity> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/ehpads")
    EhpadEntity newEphad(@RequestBody EhpadEntity newEphad) {
        return repository.save(newEphad);
    }

    // Single item

    @GetMapping("/ehpads/{id}")
    EhpadEntity one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ephad with "+ id));
    }

    @PutMapping("/ehpads/{id}")
    EhpadEntity replaceEphad(@RequestBody EhpadEntity newEphad, @PathVariable Long id) {

        return repository.findById(id)
                .map(Ephad -> {
                    Ephad.setNom(newEphad.getNom());
                    return repository.save(Ephad);
                })
                .orElseGet(() -> {
                    newEphad.setIdEhpad(id);
                    return repository.save(newEphad);
                });
    }

    @DeleteMapping("/ehpads/{id}")
    void deleteEphad(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
