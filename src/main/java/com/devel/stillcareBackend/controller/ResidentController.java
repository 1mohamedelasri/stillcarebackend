package com.devel.stillcareBackend.controller;

import com.devel.stillcareBackend.exception.exceptionmodels.BadParametersException;
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
    @GetMapping("/residents")
    List<ResidentEntity> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/residents")
    ResidentEntity newResident(@RequestBody ResidentEntity newResident) {
        return repository.save(newResident);
    }

    // Single item

    @GetMapping("/residents/{id}")
    ResidentEntity one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Resident avec id = " +id));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/residents/{nom}/{prenom}")
    ResidentEntity findByName(@PathVariable String nom, @PathVariable String prenom) {
        if(nom.isEmpty() && prenom.isEmpty()){
            throw new BadParametersException("nom : "+ nom + "prenom"+ prenom);
        }
        return repository.findByName(nom.trim(),prenom.trim())
                .orElseThrow(() -> new NotFoundException("Resident avec nom = " +nom+ "et prenom"+ prenom));
    }

    @GetMapping("/residents/noAppointment")
    List<ResidentEntity> ResidentSandRdv() {

        return repository.listResidentSansRdv();
    }

    @PutMapping("/residents/{id}")
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

    @DeleteMapping("/residents/{id}")
    void deleteResident(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/residents/ehpad/{id}")
    List<ResidentEntity> listResidentEhpad(@PathVariable Long id){
     return repository.listResidentEhpad(id);
    };

}
