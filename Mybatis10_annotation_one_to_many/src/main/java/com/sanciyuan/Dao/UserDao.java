package com.sanciyuan.Dao;

import org.apache.ibatis.annotations.*;
import com.sanciyuan.Entity.User;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * Author：
 * Date：2019/9/26 15:03
 * Content：在Mybatis中针对,增删改查有四个注解:@Select @Update @Insert @Delete
 */

public interface UserDao {

    //查询所有用户信息
    @Select("select * from user")
    //通过注解配置属性别名(@Result中id为唯一标识符)
    @Results(id = "userMap", value = {
            @Result(id = true, column = "id", property = "userId"),
            @Result(column = "username", property = "userName"),
            @Result(column = "birthday", property = "userBirthday"),
            @Result(column = "sex", property = "userSex"),
            @Result(column = "address", property = "userAddress"),
            //配置一对多的关系映射Account
            @Result(property = "accounts",column = "id",
                    many = @Many(select = "com.sanciyuan.Dao.AccountDao.findAccountByid",fetchType = FetchType.EAGER))
    })
    List<User> findAll();

    //通过Id查询用户名称
    @Select("select * from user where id=#{userId}")
    @ResultMap(value = {"userMap"})//调用别名(可以给多个属性赋值,如果只给一个别名赋值时value可以省略)
    User findByid(int number);

    //通过姓名查询
    @Select("select * from user where username like '%${value}%' ")
    @ResultMap(value = {"userMap"})//调用别名(可以给多个属性赋值,如果只给一个别名赋值时value可以省略)
    List<User> findUserByName(String username);

}
