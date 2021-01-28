package com.devel.stillcareBackend.services;


import com.devel.stillcareBackend.dao.TabletteDAO;
import com.devel.stillcareBackend.model.TabletteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Component
public class TabletteService {

    @Autowired
    private TabletteDAO productDao;

    @Transactional
    public void add(TabletteEntity product) {
        productDao.persist(product);
    }

    @Transactional
    public void addAll(Collection<TabletteEntity> products) {
        for (TabletteEntity product : products) {
            productDao.persist(product);
        }
    }

    @Transactional(readOnly = true)
    public List<TabletteEntity> listAll() {
        return productDao.findAll();

    }

}