package com.devel.stillcareBackend.repositories;
import com.devel.stillcareBackend.model.PersonnelEntity;
import com.devel.stillcareBackend.model.UniteEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UniteRepository extends JpaRepository<UniteEntity,Long>{
    @Query("select t from UniteEntity t where t.idEhpad = :id_ehpad")
    public Optional<List<UniteEntity>> findUnitesByEhpad(@Param("id_ehpad") long id_ehpad);

    // PENSER OPTIMISATION
    @Query("select u from UniteEntity u join ResidentEntity r on(r.idResident = :id_resident and r.idUnite<> u.idUnite  and u.idEhpad = :id_ehpad and u.idUnite <> r.idUnite)")
    public Optional<List<UniteEntity>> findOtherUniteOfResidentByEphad(@Param("id_ehpad") long id_ehpad,@Param("id_resident") long id_resident);
}