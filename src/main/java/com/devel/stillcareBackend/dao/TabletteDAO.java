package com.devel.stillcareBackend.dao;

import com.devel.stillcareBackend.model.TabletteEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class TabletteDAO {

    @PersistenceContext
    private EntityManager em;

    public void persist(TabletteEntity product) {
        em.persist(product);
    }

    public List<TabletteEntity> findAll() {
        return em.createQuery("SELECT p FROM TabletteEntity p").getResultList();
    }

}
