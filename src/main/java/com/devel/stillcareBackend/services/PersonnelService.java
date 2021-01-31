package com.devel.stillcareBackend.services;


import com.devel.stillcareBackend.model.PersonnelEntity;
import com.devel.stillcareBackend.repositories.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Component
public class PersonnelService {

    @Autowired
    private PersonnelRepository personnelRepository;

    @Transactional
    public void add(PersonnelEntity product) {
        personnelRepository.save(product);
    }

    @Transactional
    public void addAll(Collection<PersonnelEntity> personnels) {
        for (PersonnelEntity personnel : personnels) {
            personnelRepository.save(personnel);
        }
    }

    @Transactional(readOnly = true)
    public List<PersonnelEntity> listAll() {
        return personnelRepository.findAll();

    }

}