package com.devel.stillcareBackend.repositories;
import com.devel.stillcareBackend.model.ResidentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ResidentRepository extends JpaRepository<ResidentEntity,Long>{
    @Query("select t " +
            "from ResidentEntity t left join RendezvousEntity r on t.idResident = r.idResident " +
            "where r.idResident is NULL ")
    public List<ResidentEntity> listResidentSansRdv();

    @Query("select t from ResidentEntity t join UniteEntity u on t.idUnite=u.idUnite where u.idEhpad = :id")
    public List<ResidentEntity> listResidentEhpad(@Param("id") long id);

    @Query("select res from ResidentEntity res where res.nom = :nom and  res.prenom = :prenom")
    public Optional<ResidentEntity> findByName(@Param("nom") String nom, @Param("prenom") String prenom);
}
