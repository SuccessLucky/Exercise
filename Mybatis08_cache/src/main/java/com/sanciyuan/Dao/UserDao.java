package com.sanciyuan.Dao;

import com.sanciyuan.Entity.User;

import java.util.List;

/**
 * Author：
 * Date：2019/9/26 15:03
 * Content：用户的持久层接口
 */

public interface UserDao {

    //查询所有用户信息，同时获取到用户下所有账号的信息
//    @Select( "select * from user" )
    List<User> findAll();

    //根据id查询指定用户
    User UsernameByid(Integer id);

    //更新用户信息
    void updateUser(User user);

}
