package com.devel.stillcareBackend.repositories;
import com.devel.stillcareBackend.model.InviteEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface InviteRepository extends JpaRepository<InviteEntity,String>{

}