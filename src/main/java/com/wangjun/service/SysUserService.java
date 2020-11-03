package com.wangjun.service;

import com.wangjun.entity.SysUser;
import com.wangjun.repository.SysUserRepository;
import com.wangjun.response.MyResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 系统用户业务接口
 * @Author : 王俊
 * @date :  2020/11/3
 */
@Service
public class SysUserService {

    @Resource
    private SysUserRepository sysUserRepository;


    /**
     * 保存一条记录
     * @param sysUser 用户信息
     * @return  保存结果
     */
    public MyResponse save(SysUser sysUser){
        try {
            sysUserRepository.save(sysUser);
            return new MyResponse("success","新增成功！");
        }catch (Exception e){
            return new MyResponse("error",e.getMessage());
        }
    }

    /**
     * 查询一条记录
     * @param username 用户名称
     * @return  用户信息
     */
    public SysUser find(String username){
        return sysUserRepository.findByUsername(username);
    }

    /** 根据用户名更改数据
     * @param sysUser
     * @return
     */
    public MyResponse update(SysUser sysUser){
        //首先需要根据用户名username查询出主键，然后再使用save方法更新
        try {
            //根据新的用户名拿到老的SysUser信息
            SysUser oldSysUser = sysUserRepository.findByUsername(sysUser.getUsername());
            //给新的对象赋值老的userId
            sysUser.setUserId(oldSysUser.getUserId());
            System.out.println(sysUser);
            return new MyResponse("success","更新成功！");
        }catch (Exception e){
            return new MyResponse("error","更新失败！");
        }
    }


    /**
     * 根据用户名删除一条数据
     * @param username
     * @return
     */
    public MyResponse delete(String username){
        try {
            SysUser oldSysUser = sysUserRepository.findByUsername(username);
            sysUserRepository.delete(oldSysUser);
            return new MyResponse("success","删除成功！");
        }catch (Exception e){
            return new MyResponse("error","删除失败！");
        }
    }


    /**
     * 写入多条记录
     * @param sysUserList
     * @return
     */
    public MyResponse saveAll(List<SysUser> sysUserList){
        try {
            sysUserRepository.saveAll(sysUserList);
            return new MyResponse("success","写入多条成功！");
        }catch (Exception e){
            return new MyResponse("error","写入多条失败！");
        }
    }

    /**
     * 查看所有记录
     * @return
     */
    public List<SysUser> list(){
        return sysUserRepository.findAll();
    }

    /**
     * 分页查询
     * @param page 起始页
     * @param size 每页几条
     * @return 分页之后的信息
     */
    public Page<SysUser> page(Integer page, Integer size){
        // 根据 userId 排序，Sort.Direction.ASC/DESC 升序/降序
        PageRequest pageable = PageRequest.of(page, size, Sort.Direction.ASC, "userId");
        return sysUserRepository.findAll(pageable);
    }

    /**
     * 模糊查询+分页
     * @param nickname 昵称
     * @param page 起始页
     * @param size 每页几条
     * @return
     */
    public Page<SysUser> searchByNickname(String nickname, Integer page, Integer size) {
        // 根据 userId 排序
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "userId");
        return sysUserRepository.searchByNickname(nickname,pageable);
    }

}
