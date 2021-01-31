package com.devel.stillcareBackend.repositories;
import com.devel.stillcareBackend.model.RendezvousEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface RendezvousRepository extends JpaRepository<RendezvousEntity,Long>{

}