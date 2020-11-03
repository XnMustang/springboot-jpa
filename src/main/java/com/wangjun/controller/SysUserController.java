package com.wangjun.controller;

import com.wangjun.entity.SysUser;
import com.wangjun.response.MyResponse;
import com.wangjun.service.SysUserService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author : 王俊
 * @date :  2020/11/3
 */

@RestController
@RequestMapping(value = "/api/user")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    /**
     * 保存一条数据
     * @param sysUser
     * @return
     */
    @PostMapping(value = "/save")
    public MyResponse save(@RequestBody SysUser sysUser){
        return sysUserService.save(sysUser);
    }

    /**
     * 查询一条数据
     * @param username
     * @return
     */
    @PostMapping(value = "/find")
    public SysUser find(@RequestBody String username){
        return sysUserService.find(username);
    }

    /**
     * 更新信息
     * @param sysUser
     * @return
     */
    @PostMapping(value = "/update")
    public MyResponse update(@RequestBody SysUser sysUser){
        return sysUserService.update(sysUser);
    }

    /**
     * 根据用户名删除信息
     * @param username
     * @return
     */
    @PostMapping(value = "/delete")
    public MyResponse delete(@RequestBody String username){
        return sysUserService.delete(username);
    }

    /**
     * 写入多条记录
     * @param sysUserList
     * @return
     */
    @PostMapping(value = "/saveAll")
    public MyResponse saveAll(@RequestBody List<SysUser> sysUserList){
        return sysUserService.saveAll(sysUserList);
    }

    /**
     * 查看所有记录
     * @return
     */
    @GetMapping(value = "/list")
    public List<SysUser> list(){
        return sysUserService.list();
    }

    @PostMapping(value = "/page")
    public Page<SysUser> page(@RequestParam(defaultValue = "0") Integer page,@RequestParam(defaultValue = "2") Integer size){
        return sysUserService.page(page,size);
    }

}
