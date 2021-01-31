package com.devel.stillcareBackend.repositories;
import com.devel.stillcareBackend.model.ResidentprocheEntity;
import com.devel.stillcareBackend.model.ResidentprocheEntityPK;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ResidentprocheRepository extends JpaRepository<ResidentprocheEntity, ResidentprocheEntityPK>{


}