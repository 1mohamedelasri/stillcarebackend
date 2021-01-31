package com.devel.stillcareBackend.repositories;
import com.devel.stillcareBackend.model.ResidentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@Repository
public interface ResidentRepository extends JpaRepository<ResidentEntity,Long>{
    @Query("select t " +
            "from ResidentEntity t left join RendezvousEntity r on t.idResident = r.idResident " +
            "where r.idResident is NULL ")
    public List<ResidentEntity> listResidentSansRdv();
}