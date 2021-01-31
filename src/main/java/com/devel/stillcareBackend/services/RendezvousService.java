package com.devel.stillcareBackend.services;


import com.devel.stillcareBackend.model.RendezvousEntity;
import com.devel.stillcareBackend.model.ResidentEntity;
import com.devel.stillcareBackend.repositories.RendezvousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Component
public class RendezvousService {

    @Autowired
    private RendezvousRepository rendezvousRepository;

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

}