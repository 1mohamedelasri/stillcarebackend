package com.devel.stillcareBackend.controller;

import com.devel.stillcareBackend.exception.exceptionmodels.NotFoundException;
import com.devel.stillcareBackend.model.UniteEntity;
import com.devel.stillcareBackend.repositories.UniteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UniteController {

    private final UniteRepository repository;

    UniteController(UniteRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/Unites")
    List<UniteEntity> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/Unites")
    UniteEntity newUnitee(@RequestBody UniteEntity newUnite) {
        return repository.save(newUnite);
    }

    // Single item

    @GetMapping("/Unites/{id}")
    UniteEntity one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Unite with id= "+ id));
    }

    @PutMapping("/Unites/{id}")
    UniteEntity replaceUnitee(@RequestBody UniteEntity newUnite, @PathVariable Long id) {

        return repository.findById(id)
                .map(Unitee -> {
                    Unitee.setEtat(newUnite.getEtat());
                    Unitee.setNom(newUnite.getEtat());
                    return repository.save(Unitee);
                })
                .orElseGet(() -> {
                    newUnite.setIdUnite(id);
                    return repository.save(newUnite);
                });
    }

    @DeleteMapping("/Unites/{id}")
    void deleteUnitee(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
