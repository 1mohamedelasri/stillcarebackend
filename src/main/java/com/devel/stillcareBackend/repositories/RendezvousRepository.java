package com.devel.stillcareBackend.repositories;
import com.devel.stillcareBackend.model.PersonnelEntity;
import com.devel.stillcareBackend.model.RendezvousEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NamedNativeQuery;
import java.util.List;
import java.util.Optional;

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
    /*@Modifying
    @Query(nativeQuery = true, value = "SELECT * FROM TABLE(transfertRdv(4, 1 ))")
    void transfererRendezVous(@Param("src") long src, @Param("dst") long dst);*/

    @Query("select p from RendezvousEntity t join ResidentEntity r on(t.idResident= r.idResident) " +
            "join AffectationPersonnelEntity a on(a.idUnite= r.idUnite) " +
            "join PersonnelEntity p on(p.idPersonnel = a.idPersonnel) " +
            "where t.idRdv = :idrdv and lower(p.nom) like %:key% or lower(p.prenom) like %:key%")
    public List<PersonnelEntity> personnelBysearch(@Param("idrdv") long idrdv, @Param("key") String key);

}
