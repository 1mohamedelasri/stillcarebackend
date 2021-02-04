package com.devel.stillcareBackend.controller;

import com.devel.stillcareBackend.exception.ExceptionHelper;
import com.devel.stillcareBackend.exception.exceptionmodels.BadParametersException;
import com.devel.stillcareBackend.exception.exceptionmodels.NotFoundException;
import com.devel.stillcareBackend.model.PersonnelEntity;
import com.devel.stillcareBackend.model.ResidentEntity;
import com.devel.stillcareBackend.repositories.PersonnelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class PersonnelController {

    private final PersonnelRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHelper.class);

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

    @GetMapping("/personnels/ehpad/{id_ehpad}/unite/{id_unite}")
    List<PersonnelEntity> findPersonnelByUniteAndEhpad(@PathVariable Long id_ehpad,@PathVariable Long id_unite ){
        return repository.findPersonnelByUniteAndEhpad(id_unite,id_ehpad).orElseThrow(() -> new NotFoundException("No Personnels found for unite"+id_unite+ "of  ehpad" + id_ehpad));
    };


    @GetMapping("/personnels/search")
    PersonnelEntity findPersonnelByUnite(@RequestParam Optional<String> key ){
        return repository.searchByKey(key.orElse("")).orElseThrow(() -> new NotFoundException("No Personnels found for "+key));
    };

}
