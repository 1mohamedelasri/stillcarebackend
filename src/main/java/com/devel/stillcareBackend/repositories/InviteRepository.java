package com.devel.stillcareBackend.repositories;
import com.devel.stillcareBackend.model.InviteEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 服务类
 * @author 刘前进 xindong888@163.com  www.xjke.com
 * @since 1.0.0
 */
@Repository
public interface InviteRepository extends JpaRepository<InviteEntity,Long>{

}