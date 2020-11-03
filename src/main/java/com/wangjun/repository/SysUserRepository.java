package com.wangjun.repository;

import com.wangjun.entity.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author : 王俊
 * @date :  2020/11/3
 */

//第一个参数：指定Entity实体类
//第二个参数：指定实体类的主键类型
@Repository
public interface SysUserRepository extends JpaRepository<SysUser,Long>{

    /**
     * 自定义根据名称查询信息
     * @param username 名称
     * @return
     */
    SysUser findByUsername(String username);

    /**
     * 根据用户昵称查询用户信息，等价于findByNicknameLike
     * @param nickname 用户昵称
     * @param pageable 分页
     * @return 用户信息
     */
    @Query("SELECT sysUser from SysUser sysUser where sysUser.nickname like %:nickname%")
    Page<SysUser> searchByNickname(@Param("nickname") String nickname, Pageable pageable);

    /**
     * 根据用户昵称查询用户信息 和 searchByNickname 等价
     * @param nickname 用户昵称
     * @param pageable 分页
     * @return 用户信息
     */
    Page<SysUser> findByNicknameLike(@Param("nickname") String nickname, Pageable pageable);

}
