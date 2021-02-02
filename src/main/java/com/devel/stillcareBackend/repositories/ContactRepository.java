package com.devel.stillcareBackend.repositories;
import com.devel.stillcareBackend.model.ContactEntity;
import com.devel.stillcareBackend.model.PersonnelEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


@Repository
public interface ContactRepository extends JpaRepository<ContactEntity,Long>{
    @Query("select cnt from ContactEntity cnt where cnt.firebasetoken = :token ")
    public Optional<ContactEntity> authenticateContact(@Param("token") String token);

}