package com.devel.stillcareBackend.services;


import com.devel.stillcareBackend.model.CreneauEntity;
import com.devel.stillcareBackend.model.CreneauEntityPK;
import com.devel.stillcareBackend.model.RendezvousEntity;
import com.devel.stillcareBackend.repositories.CreneauRepository;
import com.devel.stillcareBackend.repositories.InviteRdvRepository;
import com.devel.stillcareBackend.repositories.RendezvousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
public class RendezvousService {

    @Autowired
    private InviteRdvRepository inviteRdvRepository;

    @Autowired
    private RendezvousRepository rendezvousRepository;

    @Autowired
    private CreneauRepository creneauRepository;

    @Transactional
    public void add(RendezvousEntity rendezvous) {
        rendezvousRepository.save(rendezvous);
    }

    @Transactional
    public void addAll(Collection<RendezvousEntity> lesrendezvous) {
        for (RendezvousEntity rendezvous : lesrendezvous) {
            rendezvousRepository.save(rendezvous);
        }
    }

    @Transactional(readOnly = true)
    public List<RendezvousEntity> listAll() {
        return rendezvousRepository.findAll();

    }
    @Transactional
    public void deleteRdv(long id){
        inviteRdvRepository.deleteByRdv(id);
        RendezvousEntity rdv = rendezvousRepository.getOne(id);
        CreneauEntityPK creneauid = new CreneauEntityPK();
        creneauid.setDatedebut(rdv.getDateCreneau());
        creneauid.setIdPersonnel(rdv.getIdPersonnelcreneau());
        rendezvousRepository.deleteById(id);
        creneauRepository.getOne(creneauid).setEtat("disponible");

    }

    @Transactional
    public RendezvousEntity ajouterRdv(RendezvousEntity rdv){
        CreneauEntity cr= new CreneauEntity();
        cr.setDatedebut(rdv.getDateCreneau());
        cr.setIdPersonnel(rdv.getIdPersonnelcreneau());
        cr.setEtat("programmé");
        creneauRepository.save(cr);
        return rendezvousRepository.save(rdv);

    }


}
