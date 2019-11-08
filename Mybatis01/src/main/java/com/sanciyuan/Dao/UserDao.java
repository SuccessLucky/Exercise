package com.sanciyuan.Dao;

import com.sanciyuan.Entity.User;

import java.util.List;

/**
 * Author：
 * Date：2019/9/25 15:17
 * Content：用户的持久层接口
 */

public interface UserDao {

    //查询所有用户信息
    List<User> findAll();

}
