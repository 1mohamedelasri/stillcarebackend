package com.devel.stillcareBackend.repositories;
import com.devel.stillcareBackend.model.CreneauEntity;
import com.devel.stillcareBackend.model.CreneauEntityPK;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CreneauRepository extends JpaRepository<CreneauEntity, CreneauEntityPK>{

}