package com.sanciyuan.Dao;

import com.sanciyuan.Entity.Role;

import java.util.List;

/**
 * Author：
 * Date：2019/10/31 11:41
 * Content：角色扮演
 */
public interface RoleDao {

    //查询所有角色
    List<Role> findAll();

}
