package com.wangjun.repository;

import com.wangjun.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author : 王俊
 * @date :  2020/11/3
 */
@Repository
public interface SysUserRepository extends JpaRepository<SysUser,Long>{

    //第一个参数：指定Entity实体类
    //第二个参数：指定实体类的主键类型

    SysUser findByUsername(String username);

}
