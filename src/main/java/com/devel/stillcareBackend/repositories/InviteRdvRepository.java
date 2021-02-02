package com.devel.stillcareBackend.repositories;
import com.devel.stillcareBackend.model.InviteRdvEntity;
import com.devel.stillcareBackend.model.InviteRdvEntityPK;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface InviteRdvRepository extends JpaRepository<InviteRdvEntity, InviteRdvEntityPK>{

}