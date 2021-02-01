package com.devel.stillcareBackend.repositories;
import com.devel.stillcareBackend.model.AffectationPersonnelEntity;
import com.devel.stillcareBackend.model.AffectationPersonnelEntityPK;
import com.devel.stillcareBackend.model.AffectationResidentEntityPK;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AffectationPersonnelRepository extends JpaRepository<AffectationPersonnelEntity, AffectationPersonnelEntityPK>{

}