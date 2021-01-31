package com.devel.stillcareBackend.repositories;
import com.devel.stillcareBackend.model.PersonnelEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface PersonnelRepository extends JpaRepository<PersonnelEntity,Long>{

}