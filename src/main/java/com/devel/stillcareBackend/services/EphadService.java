package com.devel.stillcareBackend.services;

import com.devel.stillcareBackend.model.EphadEntity;
import com.devel.stillcareBackend.repositories.EphadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Component
public class EphadService {

    @Autowired
    private EphadRepository ephadRepository;

    @Transactional
    public void add(EphadEntity ephad) {
        ephadRepository.save(ephad);
    }

    @Transactional
    public void addAll(Collection<EphadEntity> ephads) {
        for (EphadEntity ephad : ephads) {
            ephadRepository.save(ephad);
        }
    }

    @Transactional(readOnly = true)
    public List<EphadEntity> listAll() {
        return ephadRepository.findAll();

    }

}