package com.devel.stillcareBackend.repositories;
import com.devel.stillcareBackend.model.UniteEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface UniteRepository extends JpaRepository<UniteEntity,Long>{

}