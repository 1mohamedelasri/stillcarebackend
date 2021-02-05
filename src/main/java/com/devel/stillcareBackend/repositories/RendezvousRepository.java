package com.devel.stillcareBackend.repositories;
import com.devel.stillcareBackend.model.RendezvousEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface RendezvousRepository extends JpaRepository<RendezvousEntity,Long>{
    @Query("select t from RendezvousEntity t where t.idPersonnelcreneau = :id")
    public List<RendezvousEntity> rdvByPersonnelid(@Param("id") long id);

    @Query("select t from RendezvousEntity t where t.idResident = :id")
    public List<RendezvousEntity> rdvByResidentid(@Param("id") long id);

    @Query("select t from RendezvousEntity t where t.idResident = :idResident and t.idContact = :idContact")
    public List<RendezvousEntity> rdvByResidentContact(@Param("idResident") long idResident, @Param("idContact") long idContact);

    @Query(value = "SELECT seq_num_rendezvous.currval FROM dual", nativeQuery =
            true)
    Long getCurrentSeriesId();



}
