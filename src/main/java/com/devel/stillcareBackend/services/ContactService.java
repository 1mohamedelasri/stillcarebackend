package com.devel.stillcareBackend.services;


import com.devel.stillcareBackend.model.ContactEntity;
import com.devel.stillcareBackend.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Component
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Transactional
    public void add(ContactEntity contact) {
        contactRepository.save(contact);
    }

    @Transactional
    public void addAll(Collection<ContactEntity> contacts) {
        for (ContactEntity contact : contacts) {
            contactRepository.save(contact);
        }
    }

    @Transactional(readOnly = true)
    public List<ContactEntity> listAll() {
        return contactRepository.findAll();

    }

}