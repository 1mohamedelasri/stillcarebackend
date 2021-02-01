package com.devel.stillcareBackend.repositories;

import com.devel.stillcareBackend.model.AffectationPersonnelEntity;
import com.devel.stillcareBackend.model.AffectationPersonnelEntityPK;
import com.devel.stillcareBackend.model.HistAffectationPersonnelEntity;
import com.devel.stillcareBackend.model.HistAffectationPersonnelEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryAffectationPersonnelRepository extends JpaRepository<HistAffectationPersonnelEntity, HistAffectationPersonnelEntityPK>{

}