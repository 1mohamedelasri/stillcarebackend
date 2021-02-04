package com.devel.stillcareBackend.controller;

import com.devel.stillcareBackend.exception.ExceptionHelper;
import com.devel.stillcareBackend.exception.exceptionmodels.BadParametersException;
import com.devel.stillcareBackend.exception.exceptionmodels.NotFoundException;
import com.devel.stillcareBackend.model.ResidentEntity;
import com.devel.stillcareBackend.repositories.ResidentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ResidentController {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHelper.class);

    private final ResidentRepository repository;

    ResidentController(ResidentRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/residents/pages")
    Page<ResidentEntity> findAll(@RequestParam Optional<Integer> page, @RequestParam Optional<Integer> limit) {
        return repository.findAllByPage(PageRequest.of(page.orElse(1),limit.orElse(1)));
    }

    @PostMapping("/residents")
    ResidentEntity newResident(@RequestBody ResidentEntity newResident) {
        var obj =  repository.save(newResident);
        if(obj == null) new BadParametersException("le resident "+ newResident.toString());
        return  obj;
    }

    // Single item

    @GetMapping("/residents/{id}")
    ResidentEntity one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Resident avec id = " +id));
    }

    @GetMapping("/residents/{nom}/{prenom}")
    ResidentEntity findByName(@PathVariable String nom, @PathVariable String prenom) {
        if(nom.isEmpty() || prenom.isEmpty()){
            throw new BadParametersException("nom : "+ nom + "prenom"+ prenom);
        }
        return repository.findByName(nom.trim(),prenom.trim())
                .orElseThrow(() -> new NotFoundException("Resident avec nom = " +nom+ "et prenom"+ prenom));
    }

    @GetMapping("/residents/noAppointment")
    List<ResidentEntity> ResidentSandRdv() {

        return repository.listResidentSansRdv();
    }

    @GetMapping("/residents/ephad/{idehpad}/unite/{idunite}")
    List<ResidentEntity> ResidentSandRdv(@PathVariable Long idehpad, @PathVariable Long idunite) {

        return repository.listResidentEhpadUnite(idehpad,idunite);
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

    @GetMapping("/residents/ehpad/{id}")
    List<ResidentEntity> listResidentEhpad(@PathVariable Long id){
        return repository.listResidentEhpad(id);
    };

    @GetMapping("/residents/contact/{id}")
    List<ResidentEntity> listResidentContact(@PathVariable Long id){
        return repository.findByContact(id);
    };






}
