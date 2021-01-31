package com.devel.stillcareBackend.controller;

import com.devel.stillcareBackend.exception.exceptionmodels.NotFoundException;
import com.devel.stillcareBackend.model.RendezvousEntity;
import com.devel.stillcareBackend.repositories.RendezvousRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RendezvousController {

    private final RendezvousRepository repository;

    RendezvousController(RendezvousRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/Rendezvous")
    List<RendezvousEntity> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/Rendezvous")
    RendezvousEntity newRendezvous(@RequestBody RendezvousEntity newRendezvous) {
        return repository.save(newRendezvous);
    }

    // Single item

    @GetMapping("/Rendezvous/{id}")
    RendezvousEntity one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Rendezvous avec id = " +id));
    }

    @PutMapping("/Rendezvous/{id}")
    RendezvousEntity replaceRendezvous(@RequestBody RendezvousEntity newRendezvous, @PathVariable Long id) {

        return repository.findById(id)
                .map(rendezvous -> {
                    rendezvous.setEtat(newRendezvous.getEtat());
                    rendezvous.setDatedebutRdv(newRendezvous.getDatedebutRdv());
                    rendezvous.setDatefinRdv(newRendezvous.getDatefinRdv());
                    rendezvous.setStatut(newRendezvous.getStatut());
                    rendezvous.setDateCreneau(newRendezvous.getDateCreneau());
                    rendezvous.setIdPersonnelcreneau(newRendezvous.getIdPersonnelcreneau());
                    rendezvous.setIdTablette(newRendezvous.getIdTablette());
                    rendezvous.setIdResident(newRendezvous.getIdResident());
                    return repository.save(rendezvous);
                })
                .orElseGet(() -> {
                    newRendezvous.setIdRdv(id);
                    return repository.save(newRendezvous);
                });
    }

    @DeleteMapping("/Rendezvous/{id}")
    void deleteRendezvous(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
