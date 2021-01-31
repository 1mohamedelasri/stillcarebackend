package com.devel.stillcareBackend.controller;

import com.devel.stillcareBackend.exception.exceptionmodels.NotFoundException;
import com.devel.stillcareBackend.model.ContactEntity;
import com.devel.stillcareBackend.repositories.ContactRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    private final ContactRepository repository;

    ContactController(ContactRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/contacts")
    List<ContactEntity> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/contacts")
    ContactEntity newContact(@RequestBody ContactEntity newContact) {
        return repository.save(newContact);
    }

    // Single item

    @GetMapping("/contacts/{id}")
    ContactEntity one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Contact with id = "+ id));
    }

    @PutMapping("/contacts/{id}")
    ContactEntity replaceContact(@RequestBody ContactEntity newContact, @PathVariable Long id) {

        return repository.findById(id)
                .map(Contact -> {
                    Contact.setNom(newContact.getNom());
                    Contact.setPrenom(newContact.getPrenom());
                    Contact.setNumtel(newContact.getNumtel());
                    return repository.save(Contact);
                })
                .orElseGet(() -> {
                    newContact.setIdContact(id);
                    return repository.save(newContact);
                });
    }

    @DeleteMapping("/contacts/{id}")
    void deleteContact(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
