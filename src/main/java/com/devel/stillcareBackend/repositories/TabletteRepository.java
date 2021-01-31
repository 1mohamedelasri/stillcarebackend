package com.devel.stillcareBackend.repositories;

import com.devel.stillcareBackend.model.TabletteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TabletteRepository extends JpaRepository<TabletteEntity,Long> {
    @Query("select t from TabletteEntity t where t.etat like :etat ")
    public List<TabletteEntity> tabletteParStatut(@Param("etat") String etat);
}
