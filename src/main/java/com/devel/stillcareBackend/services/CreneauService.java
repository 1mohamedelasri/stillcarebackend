package com.devel.stillcareBackend.services;


import com.devel.stillcareBackend.model.CreneauEntity;
import com.devel.stillcareBackend.repositories.CreneauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.List;

@Component
public class CreneauService {

    @Autowired
    private CreneauRepository creneauRepository;

    @Transactional
    public void add(CreneauEntity creneau) {
        creneauRepository.save(creneau);
    }

    @Transactional
    public void addAll(Collection<CreneauEntity> creneaux) {
        for (CreneauEntity creneau : creneaux) {
            creneauRepository.save(creneau);
        }
    }

    @Transactional(readOnly = true)
    public List<CreneauEntity> listAll() {
        return creneauRepository.findAll();

    }

}