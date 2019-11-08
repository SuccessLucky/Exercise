package com.sanciyuan.Dao;

import com.sanciyuan.Entity.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * Author：
 * Date：2019/11/5 16:56
 * Content：
 */
public interface AccountDao {

    //查询所有账号,并且获取每个账号所属的用户信息
    @Select( "select * from account" )
    @Results(id = "accountMap",value = {
            @Result(id = true,column ="id",property = "id"),
            @Result(column ="uid",property = "uid"),
            @Result(column ="money",property = "money"),
            //加载User的信息(此处的column对应的是需要对比的表中的主键属性)
            @Result(property = "user",column = "uid",one = @One(select="com.sanciyuan.Dao.UserDao.findByid",fetchType = FetchType.EAGER))
    })
    List<Account> findAll();

    //根据用户Id查询用户信息
    @Select( "select * from account where uid=#{userId}" )
    List<Account> findAccountByid(Integer userid);


}
