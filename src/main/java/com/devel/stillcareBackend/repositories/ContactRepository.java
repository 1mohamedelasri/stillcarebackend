package com.devel.stillcareBackend.repositories;
import com.devel.stillcareBackend.model.ContactEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ContactRepository extends JpaRepository<ContactEntity,Long>{
}