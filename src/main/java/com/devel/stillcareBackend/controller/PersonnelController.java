package com.devel.stillcareBackend.controller;

import com.devel.stillcareBackend.exception.exceptionmodels.BadParametersException;
import com.devel.stillcareBackend.exception.exceptionmodels.NotFoundException;
import com.devel.stillcareBackend.model.PersonnelEntity;
import com.devel.stillcareBackend.model.ResidentEntity;
import com.devel.stillcareBackend.repositories.PersonnelRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/personnels/athentication")
    PersonnelEntity one(@RequestBody Map<String,String> playload) {
        if(playload == null) throw new BadParametersException("login : " + playload);
        return repository.authenticatePersonnel(playload.get("mail"),playload.get("password"))
                .orElseThrow(()-> new NotFoundException("User or password are incorrect"));
    }


    @DeleteMapping("/personnels/{id}")
    void deletePersonnel(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/personnels/ehpad/{id}")
    List<PersonnelEntity> listPersonnelsEhpad(@PathVariable Long id){
        return repository.listPersonnelEhpad(id).orElseThrow(() -> new NotFoundException("No Personnels found for ephads"+id));
    };

    @GetMapping("/personnels/unites/{id}")
    List<PersonnelEntity> findPersonnelByUnite(@PathVariable Long id){
        return repository.findPersonnelByUnite(id).orElseThrow(() -> new NotFoundException("No Personnels found for unite"+id));
    };

}
