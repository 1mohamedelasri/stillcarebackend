package com.devel.stillcareBackend.controller;

import com.devel.stillcareBackend.exception.exceptionmodels.NotFoundException;
import com.devel.stillcareBackend.model.PersonnelEntity;
import com.devel.stillcareBackend.repositories.PersonnelRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonnelController {

    private final PersonnelRepository repository;

    PersonnelController(PersonnelRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/personnels")
    List<PersonnelEntity> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/personnels")
    PersonnelEntity newPersonnel(@RequestBody PersonnelEntity newPersonnel) {
        return repository.save(newPersonnel);
    }

    // Single item

    @GetMapping("/personnels/{id}")
    PersonnelEntity one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("personnel with id = "+id));
    }

    @PutMapping("/personnels/{id}")
    PersonnelEntity replacePersonnel(@RequestBody PersonnelEntity newPersonnel, @PathVariable Long id) {

        return repository.findById(id)
                .map(obj -> {
                    obj.setDatedebut(newPersonnel.getDatedebut());
                    obj.setNtel(newPersonnel.getNtel());
                    obj.setDatefin(newPersonnel.getDatefin());
                    obj.setFonction(newPersonnel.getFonction());
                    return repository.save(obj);
                })
                .orElseGet(() -> {
                    newPersonnel.setIdPersonnel(id);
                    return repository.save(newPersonnel);
                });
    }

    @DeleteMapping("/personnels/{id}")
    void deletePersonnel(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
