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
    @GetMapping("/unites")
    List<UniteEntity> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/unites")
    UniteEntity newUnitee(@RequestBody UniteEntity newUnite) {
        return repository.save(newUnite);
    }

    // Single item

    @GetMapping("/unites/{id}")
    UniteEntity one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Unite with id= "+ id));
    }

    @GetMapping("/unites/ehpad/{id}")
    List<UniteEntity> findUnitesByEhpad(@PathVariable Long id) {

        return repository.findUnitesByEhpad(id)
                .orElseThrow(() -> new NotFoundException("Unite with id= "+ id));
    }

    @GetMapping("/unites/{resident}/ehpad/{idephad}")
    List<UniteEntity> findOtherUniteOfResidentByEphad(@PathVariable Long resident, @PathVariable Long idephad) {
        return repository.findOtherUniteOfResidentByEphad(idephad,resident)
                .orElseThrow(() -> new NotFoundException("Unite with idphad = "+ idephad));
    }

    @PutMapping("/unites/{id}")
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

    @DeleteMapping("/unites/{id}")
    void deleteUnitee(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
