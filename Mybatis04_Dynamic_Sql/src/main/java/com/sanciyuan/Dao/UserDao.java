package com.sanciyuan.Dao;

import com.sanciyuan.Entity.QueryVo;
import com.sanciyuan.Entity.User;

import java.util.List;

/**
 * Author：
 * Date：2019/9/26 15:03
 * Content：用户的持久层接口
 */

public interface UserDao {

    //查询所有用户信息
//    @Select( "select * from user" )
    List<User> findAll();

    //保存用户(添加用户)
    void saveUser(User user);

    //更新用户
    void updateUser(User user);

    //删除指定用户
    void deleteUser(Integer id);

    //根据id查询指定用户
    User UsernameByid(Integer id);

    //根据用户名模糊查询
    List<User> Usernamebydim(String name);

    //获取用户的总记录条数
    int findTotal();

    //根据queryVo的查询用户
    List<User> findUserByVo(QueryVo queryVo);

    //根据参入的参数条件查询(传入的参数可以是任意参数都查询)
    List<User> findUserByCondition(User user);

    //通过QueryVo实体类进行查询
    List<User> findUserInIds(QueryVo vo);


}
