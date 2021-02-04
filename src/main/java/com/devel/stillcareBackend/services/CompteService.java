package com.devel.stillcareBackend.services;

import com.devel.stillcareBackend.model.*;
import com.devel.stillcareBackend.model.costume.ContactWithResident;
import com.devel.stillcareBackend.model.costume.ResidentIds;
import com.devel.stillcareBackend.repositories.ContactRepository;
import com.devel.stillcareBackend.repositories.ResidentprocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CompteService {
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ResidentprocheRepository residentprocheRepository;

    @Transactional
    public ContactEntity SaveContactWithResident(ContactWithResident obj) {
        contactRepository.save(obj.getContact());
        ContactEntity contact = contactRepository.authenticateContact(obj.getContact().getFirebasetoken()).get();
        for (ResidentIds resident: obj.getResidentIds() ) {
            ResidentprocheEntity entity = new ResidentprocheEntity();
            entity.setIdContact(contact.getIdContact());
            entity.setIdResident(resident.id);
            entity.setLienfamilial(resident.lienFamille);
            residentprocheRepository.save(entity);
        }
        return contact;
    }

}
