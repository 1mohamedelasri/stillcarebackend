package com.devel.stillcareBackend.repositories;
import com.devel.stillcareBackend.model.PersonnelEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
@Repository
public interface PersonnelRepository extends JpaRepository<PersonnelEntity,Long>{
    @Query("select t from PersonnelEntity t where t.idEhpad = :id")
    public List<PersonnelEntity> listPersonnelEhpad(@Param("id") long id);

}
