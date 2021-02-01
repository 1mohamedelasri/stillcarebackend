package com.devel.stillcareBackend.repositories;
import com.devel.stillcareBackend.model.PersonnelEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 服务类
 * @author 刘前进 xindong888@163.com  www.xjke.com
 * @since 1.0.0
 */
@Repository
public interface PersonnelRepository extends JpaRepository<PersonnelEntity,Long>{
    @Query("select t from PersonnelEntity t where t.idEhpad = :id")
    public List<PersonnelEntity> listPersonnelEhpad(@Param("id") long id);

}
