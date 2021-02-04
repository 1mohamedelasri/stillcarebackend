package com.devel.stillcareBackend.repositories;
import com.devel.stillcareBackend.model.InviteRdvEntity;
import com.devel.stillcareBackend.model.InviteRdvEntityPK;
import com.devel.stillcareBackend.model.PersonnelEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


@Repository
public interface InviteRdvRepository extends JpaRepository<InviteRdvEntity, InviteRdvEntityPK>{

    @Modifying
    @Query("delete from InviteRdvEntity e where e.idRdv=:idRdv")
    public void deleteByRdv(@Param("idRdv") long idRdv);
}
