package com.devel.stillcareBackend.repositories;
import com.devel.stillcareBackend.model.CreneauEntity;
import com.devel.stillcareBackend.model.CreneauEntityPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
@Repository
public interface CreneauRepository extends JpaRepository<CreneauEntity, CreneauEntityPK>{
    @Query("select t from CreneauEntity t where t.idPersonnel=:id and t.datedebut not in (select datedebut from RendezvousEntity where idPersonnel = :id)")
    public List<CreneauEntity> CreneauSansRdv(@Param("id") Long id);

}
