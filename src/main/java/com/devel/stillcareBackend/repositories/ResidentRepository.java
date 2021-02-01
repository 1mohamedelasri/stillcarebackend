package com.devel.stillcareBackend.repositories;
import com.devel.stillcareBackend.model.ResidentEntity;
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
public interface ResidentRepository extends JpaRepository<ResidentEntity,Long>{
    @Query("select t " +
            "from ResidentEntity t left join RendezvousEntity r on t.idResident = r.idResident " +
            "where r.idResident is NULL ")
    public List<ResidentEntity> listResidentSansRdv();

    @Query("select t from ResidentEntity t where t.idEhpad = :id")
    public List<ResidentEntity> listResidentEhpad(@Param("id") long id);
}
