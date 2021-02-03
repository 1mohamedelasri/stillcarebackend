package com.devel.stillcareBackend.repositories;
import com.devel.stillcareBackend.model.RendezvousEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
@Repository
public interface RendezvousRepository extends JpaRepository<RendezvousEntity,Long>{
    @Query("select t from RendezvousEntity t where t.idPersonnelcreneau = :id")
    public List<RendezvousEntity> rdvByPersonnelid(@Param("id") long id);

    @Query("select t from RendezvousEntity t where t.idResident = :id")
    public List<RendezvousEntity> rdvByResidentid(@Param("id") long id);

}
