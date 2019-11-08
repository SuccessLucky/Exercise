package com.sanciyuan.Dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import com.sanciyuan.Entity.User;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Author：
 * Date：2019/9/26 15:03
 * Content：在Mybatis中针对,增删改查有四个注解:@Select @Update @Insert @Delete
 */

public interface UserDao {

    //查询所有用户信息
    @Select( "select * from user" )
    List<User> findAll();

    //添加用户
    @Insert( "insert into user(username,birthday,sex,address) values(#{username},#{birthday},#{sex},#{address})" )
    int Save(User user);

    //更新用户
    @Update( "update user set username=#{username},birthday=#{birthday},sex=#{sex},address=#{address} where id=#{id}" )
    int update(User user);

    //删除用户
    @Delete( "delete from user where id=#{id}")
    int Delete(int number);

    //通过Id查询用户名称
    @Select( "select * from user where id=#{id}" )
    User findByid(int number);

    //通过姓名查询
    @Select( "select * from user where username like '%${value}%' " )
    List<User> findUserByName(String username);

    //查询用户的总数
    @Select( "select count(*) from user" )
    int findTotalUser();

}
