package com.sanciyuan.Dao;

import java.util.List;
import com.sanciyuan.Entity.User;
import org.apache.ibatis.annotations.Select;

/**
 * Author：
 * Date：2019/9/26 15:03
 * Content：
 */

public interface UserDao {

    //查询所有用户信息
    @Select( "select * from user" )//通过@Select限定Sql语句
    List<User> findAll();

}
