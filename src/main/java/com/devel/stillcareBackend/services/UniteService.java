package com.devel.stillcareBackend.services;

import com.devel.stillcareBackend.model.TabletteEntity;
import com.devel.stillcareBackend.repositories.TabletteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Component
public class UniteService {

    @Autowired
    private TabletteRepository tabletteRespository;

    @Transactional
    public void add(TabletteEntity unite) {
        tabletteRespository.save(unite);
    }

    @Transactional
    public void addAll(Collection<TabletteEntity> unites) {
        for (TabletteEntity unite : unites) {
            tabletteRespository.save(unite);
        }
    }

    @Transactional(readOnly = true)
    public List<TabletteEntity> listAll() {
        return tabletteRespository.findAll();

    }

}