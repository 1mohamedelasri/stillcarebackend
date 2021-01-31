package com.devel.stillcareBackend.services;

import com.devel.stillcareBackend.model.*;
import com.devel.stillcareBackend.model.costume.ContactWithResident;
import com.devel.stillcareBackend.model.costume.ResidentIds;
import com.devel.stillcareBackend.repositories.ContactRepository;
import com.devel.stillcareBackend.repositories.ResidentRepository;
import com.devel.stillcareBackend.repositories.ResidentprocheRepository;
import com.devel.stillcareBackend.repositories.TabletteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class CompteService {
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ResidentprocheRepository residentRepository;

    @Transactional
    public ResidentprocheEntity SaveContactWithResident(ContactWithResident obj) {
        ResidentprocheEntity entity = new ResidentprocheEntity();
        contactRepository.save(obj.getContact());

        for (ResidentIds resident: obj.getResidentIds() ) {
            entity.setIdContact(obj.getContact().getIdContact());
            entity.setIdResident(resident.id);
            entity.setLienfamilial(resident.lienFamille);
            residentRepository.save(entity);
        }
        return entity;
    }

}
