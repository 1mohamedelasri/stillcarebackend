package com.devel.stillcareBackend.repositories;
import com.devel.stillcareBackend.model.InviterdvEntityPK;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.devel.stillcareBackend.model.InviterdvEntity;

/**
 * 服务类
 * @author 刘前进 xindong888@163.com  www.xjke.com
 * @since 1.0.0
 */
@Repository
public interface InviteRdvRepository extends JpaRepository<InviterdvEntity, InviterdvEntityPK>{

}