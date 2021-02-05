package com.devel.stillcareBackend.services;


import com.devel.stillcareBackend.model.*;
import com.devel.stillcareBackend.model.costume.RendezvousWithInvites;
import com.devel.stillcareBackend.repositories.CreneauRepository;
import com.devel.stillcareBackend.repositories.InviteRdvRepository;
import com.devel.stillcareBackend.repositories.InviteRepository;
import com.devel.stillcareBackend.repositories.RendezvousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

@Service
public class RendezvousService {

    @PersistenceContext
    EntityManager em;
    EntityManagerFactory emf;


    @Autowired
    private InviteRepository inviteRepository;

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
    public void ajouterRdv(RendezvousWithInvites rdv){
        CreneauEntity cr= new CreneauEntity();
        cr.setDatedebut(rdv.getRendezvous().getDateCreneau());
        cr.setIdPersonnel(rdv.getRendezvous().getIdPersonnelcreneau());
        cr.setEtat("programmé");
        creneauRepository.save(cr);
        inviteRepository.saveAll( rdv.getInviterlist());
        rendezvousRepository.save(rdv.getRendezvous());
        long i=rendezvousRepository.getCurrentSeriesId();
        for (InviteEntity inviter:rdv.getInviterlist()) {
            InviteRdvEntity invrdv= new InviteRdvEntity();
            invrdv.setIdRdv(i);
            invrdv.setMailInvite(inviter.getMail());
            inviteRdvRepository.save(invrdv);
            
        }


    }

    @Transactional
    public void deleteRendezVous(long src, long dst){
        String str = "select transfertRdv("+src+", "+dst+" ) from dual";

        Query query = (Query) em.createNativeQuery(str);
    }




}
