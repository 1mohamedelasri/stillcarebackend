package com.devel.stillcareBackend.controller;

import com.devel.stillcareBackend.exception.exceptionmodels.NotFoundException;
import com.devel.stillcareBackend.model.ResidentEntity;
import com.devel.stillcareBackend.repositories.ResidentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResidentController {

    private final ResidentRepository repository;

    ResidentController(ResidentRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/Residents")
    List<ResidentEntity> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/Residents")
    ResidentEntity newResident(@RequestBody ResidentEntity newResident) {
        return repository.save(newResident);
    }

    // Single item

    @GetMapping("/Residents/{id}")
    ResidentEntity one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Resident avec id = " +id));
    }

    @GetMapping("/Residents/noAppointment")
    List<ResidentEntity> ResidentSandRdv() {

        return repository.listResidentSansRdv();
    }

    @PutMapping("/Residents/{id}")
    ResidentEntity replaceResident(@RequestBody ResidentEntity newResident, @PathVariable Long id) {

        return repository.findById(id)
                .map(Resident -> {
                    Resident.setStatut(newResident.getStatut());
                    Resident.setDatenaissance(newResident.getDatenaissance());
                    return repository.save(Resident);
                })
                .orElseGet(() -> {
                    newResident.setIdResident(id);
                    return repository.save(newResident);
                });
    }

    @DeleteMapping("/Residents/{id}")
    void deleteResident(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
