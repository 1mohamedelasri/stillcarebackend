package com.devel.stillcareBackend.services;

import com.devel.stillcareBackend.model.TabletteEntity;
import com.devel.stillcareBackend.repositories.TabletteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.List;

@Component
public class TabletteService {

    @Autowired
    private TabletteRepository tabletteRespository;

    @Transactional
    public void add(TabletteEntity tablette) {
        tabletteRespository.save(tablette);
    }

    @Transactional
    public void addAll(Collection<TabletteEntity> tablettes) {
        for (TabletteEntity tablette : tablettes) {
            tabletteRespository.save(tablette);
        }
    }

    @Transactional(readOnly = true)
    public List<TabletteEntity> listAll() {
        return tabletteRespository.findAll();

    }

}