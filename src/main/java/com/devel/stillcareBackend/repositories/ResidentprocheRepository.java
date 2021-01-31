package com.devel.stillcareBackend.repositories;
import com.devel.stillcareBackend.model.ResidentprocheEntity;
import com.devel.stillcareBackend.model.ResidentprocheEntityPK;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 服务类
 * @author 刘前进 xindong888@163.com  www.xjke.com
 * @since 1.0.0
 */
@Repository
public interface ResidentprocheRepository extends JpaRepository<ResidentprocheEntity, ResidentprocheEntityPK>{


}