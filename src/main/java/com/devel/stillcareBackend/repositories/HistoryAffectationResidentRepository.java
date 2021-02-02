package com.devel.stillcareBackend.repositories;
import com.devel.stillcareBackend.model.AffectationPersonnelEntity;
import com.devel.stillcareBackend.model.HistAffectationPersonnelEntity;
import com.devel.stillcareBackend.model.HistAffectationResidentEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface HistoryAffectationResidentRepository extends JpaRepository<HistAffectationPersonnelEntity, HistAffectationResidentEntity>{

}