package com.devel.stillcareBackend.repositories;
import com.devel.stillcareBackend.model.RendezvousEntity;
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
public interface RendezvousRepository extends JpaRepository<RendezvousEntity,Long>{
    @Query("select t from RendezvousEntity t where t.idPersonnel = :id")
    public List<RendezvousEntity> rdvByPersonnelid(@Param("id") long id);

}
