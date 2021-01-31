package com.devel.stillcareBackend.repositories;
import com.devel.stillcareBackend.model.AffectationEntityPK;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.devel.stillcareBackend.model.AffectationEntity;

/**
 * 服务类
 * @author 刘前进 xindong888@163.com  www.xjke.com
 * @since 1.0.0
 */
@Repository
public interface AffectationRepository extends JpaRepository<AffectationEntity, AffectationEntityPK>{

}