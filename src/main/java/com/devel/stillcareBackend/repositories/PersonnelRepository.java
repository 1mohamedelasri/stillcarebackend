package com.devel.stillcareBackend.repositories;
import com.devel.stillcareBackend.model.PersonnelEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;
@Repository
public interface PersonnelRepository extends JpaRepository<PersonnelEntity,Long>{
    @Query("select pers from PersonnelEntity pers where pers.login = :username and pers.password = :password ")
    public Optional<PersonnelEntity> authenticatePersonnel(@Param("username") String username, @Param("password") String password);

    @Query("select t from PersonnelEntity t where t.idEhpad = :id_ehpad")
    public Optional<List<PersonnelEntity>> listPersonnelEhpad(@Param("id_ehpad") long id_ehpad);

    @Query("select p from AffectationPersonnelEntity t join  PersonnelEntity p on(t.idPersonnel = p.idPersonnel) where t.idUnite = :id_unite")
    public Optional<List<PersonnelEntity>> findPersonnelByUnite(@Param("id_unite") long id_unite);

    @Query("select p from AffectationPersonnelEntity t join  PersonnelEntity p on(t.idUnite = :id_unite and p.idEhpad = :id_ehpad and t.idPersonnel = p.idPersonnel)  ")
    public Optional<List<PersonnelEntity>> findPersonnelByUniteAndEhpad(@Param("id_unite") long id_unite, @Param("id_ehpad") long id_ehpad);

}
