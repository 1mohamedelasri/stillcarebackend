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

    @Query("select u from UniteEntity u where u.idEhpad = :id_ehpad")
    public Optional<List<UniteEntity>> findOtherUniteOfResidentByEphad(@Param("id_ehpad") long id_ehpad);
}