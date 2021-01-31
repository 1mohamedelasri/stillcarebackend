package com.devel.stillcareBackend.repositories;
import com.devel.stillcareBackend.model.AffectationPersonnelEntity;
import com.devel.stillcareBackend.model.AffectationPersonnelEntityPK;
import com.devel.stillcareBackend.model.AffectationResidentEntityPK;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 服务类
 * @author 刘前进 xindong888@163.com  www.xjke.com
 * @since 1.0.0
 */
@Repository
public interface AffectationPersonnelRepository extends JpaRepository<AffectationPersonnelEntity, AffectationResidentEntityPK>{

}