package com.devel.stillcareBackend.controller;

import com.devel.stillcareBackend.exception.exceptionmodels.NotFoundException;
import com.devel.stillcareBackend.model.RendezvousEntity;
import com.devel.stillcareBackend.repositories.RendezvousRepository;
import com.devel.stillcareBackend.services.RendezvousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RendezvousController {

    private final RendezvousRepository repository;

    @Autowired
    RendezvousService service;

    RendezvousController(RendezvousRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/rendezvous")
    List<RendezvousEntity> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/rendezvous")
    RendezvousEntity newRendezvous(@RequestBody RendezvousEntity newRendezvous) {
        return service.ajouterRdv(newRendezvous);
    }

    // Single item

    @GetMapping("/rendezvous/{id}")
    RendezvousEntity one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Rendezvous avec id = " +id));
    }

    @PutMapping("/rendezvous/{id}")
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

    @DeleteMapping("/rendezvous/{id}")
    void deleteRendezvous(@PathVariable Long id) {
        service.deleteRdv(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/rendezvous/personnel/{id}")
    List<RendezvousEntity> getRdvByPersonnel(@PathVariable long id){
        return repository.rdvByPersonnelid(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/rendezvous/resident/{id}")
    List<RendezvousEntity> getRdvByCreneau(@PathVariable long id){
        return repository.rdvByResidentid(id);
    }

    @GetMapping("/rendezvous/resident/{idContact}/{idResident}")
    List<RendezvousEntity> getRdvByResidentContact(@PathVariable long idResident, @PathVariable long idContact){
        return repository.rdvByResidentContact(idResident,idContact);
    }


}
