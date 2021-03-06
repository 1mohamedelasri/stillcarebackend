package com.devel.stillcareBackend.controller;

import com.devel.stillcareBackend.exception.exceptionmodels.NotFoundException;
import com.devel.stillcareBackend.model.InviteEntity;
import com.devel.stillcareBackend.repositories.InviteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InviteController {

    private final InviteRepository repository;

    InviteController(InviteRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/invites")
    List<InviteEntity> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/invites")
    InviteEntity newInvite(@RequestBody InviteEntity newTablette) {
        return repository.save(newTablette);
    }

    // Single item

    @GetMapping("/invites/{id}")
    InviteEntity one(@PathVariable String mail) {

        return repository.findById(mail)
                .orElseThrow(() -> new NotFoundException("invité with id = " +mail));
    }

    @PutMapping("/invites/{id}")
    InviteEntity replaceInvite(@RequestBody InviteEntity newInvite, @PathVariable String mail) {

        return repository.findById(mail)
                .map(Invite -> {
                    Invite.setNom(newInvite.getNom());
                    Invite.setMail(newInvite.getMail());
                    Invite.setPrenom(newInvite.getPrenom());
                    return repository.save(Invite);
                })
                .orElseGet(() -> {
                    newInvite.setMail(mail);
                    return repository.save(newInvite);
                });
    }

    @DeleteMapping("/invites/{id}")
    void deleteInvite(@PathVariable String mail) {
        repository.deleteById(mail);
    }

}
