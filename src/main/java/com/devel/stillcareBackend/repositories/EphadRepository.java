package com.devel.stillcareBackend.repositories;
import com.devel.stillcareBackend.model.EhpadEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface EphadRepository extends JpaRepository<EhpadEntity,Long>{

}