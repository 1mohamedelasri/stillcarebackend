package com.devel.stillcareBackend.services;


import com.devel.stillcareBackend.model.ContactEntity;
import com.devel.stillcareBackend.model.InviteEntity;
import com.devel.stillcareBackend.repositories.InviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Component
public class InviteService {

    @Autowired
    private InviteRepository inviteRepository;

    @Transactional
    public void add(InviteEntity invite) {
        inviteRepository.save(invite);
    }

    @Transactional
    public void addAll(Collection<InviteEntity> invites) {
        for (InviteEntity invite : invites) {
            inviteRepository.save(invite);
        }
    }

    @Transactional(readOnly = true)
    public List<InviteEntity> listAll() {
        return inviteRepository.findAll();

    }

}