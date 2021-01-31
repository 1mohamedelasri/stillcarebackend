package com.devel.stillcareBackend.services;


import com.devel.stillcareBackend.model.ResidentEntity;
import com.devel.stillcareBackend.repositories.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Component
public class ResidentService {

    @Autowired
    private ResidentRepository residentRepository;

    @Transactional
    public void add(ResidentEntity resident) {
        residentRepository.save(resident);
    }

    @Transactional
    public void addAll(Collection<ResidentEntity> residents) {
        for (ResidentEntity resident : residents) {
            residentRepository.save(resident);
        }
    }

    @Transactional(readOnly = true)
    public List<ResidentEntity> listAll() {
        return residentRepository.findAll();

    }

}