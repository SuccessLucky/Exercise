package com.sanciyuan.Impl;

import com.sanciyuan.Dao.UserDao;
import com.sanciyuan.Entity.QueryVo;
import com.sanciyuan.Entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Author：
 * Date：2019/10/8 8:45
 * Content：
 */
public class UserDaoImpl implements UserDao {

    private SqlSessionFactory factory;

    //创建有参构造方法
    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    //查询所有用户方法
    @Override
    public List<User> findAll() {
        //打开一个会话工厂
        SqlSession session=factory.openSession();
        List<User> listfindAll = session.selectList( "com.sanciyuan.Dao.UserDao.findAll" );
        session.close();
        return listfindAll;
    }

    //插入数据
    @Override
    public void saveUser(User user) {
        //打开一个会话工厂
        SqlSession session=factory.openSession();
        session.insert( "com.sanciyuan.Dao.UserDao.saveUser",user);
        //提交事务
        session.commit();
        //关闭会话工厂
        session.close();
    }

    //用户的更新
    @Override
    public void updateUser(User user) {
        //打开一个会话工厂
        SqlSession session=factory.openSession();
        session.update( "com.sanciyuan.Dao.UserDao.updateUser",user);
        //提交事务
        session.commit();
        //关闭会话工厂
        session.close();
    }

    //删除用户操作
    @Override
    public void deleteUser(Integer id) {
        //打开一个会话工厂
        SqlSession session=factory.openSession(true);//在openSession中添加一个true,着设置为自动提交
        session.delete( "com.sanciyuan.Dao.UserDao.deleteUser",id);
        //提交事务
//        session.commit();
        //关闭会话工厂
        session.close();
    }

    //根据id查询指定用户
    @Override
    public User UsernameByid(Integer id) {
        //打开一个会话工厂
        SqlSession session=factory.openSession();
        //查询用户单个文件
        User userone = session.selectOne( "com.sanciyuan.Dao.UserDao.UsernameByid",id );
        //关闭查询
        session.close();
        return userone;
    }

    //根据用户姓名进行模糊查询
    @Override
    public List<User> Usernamebydim(String name) {
        //打开一个会话工厂
        SqlSession session=factory.openSession();
        //查询用户单个文件
        List<User> user = session.selectList( "com.sanciyuan.Dao.UserDao.Usernamebydim", name );
        //关闭查询
        session.close();
        return user;
    }

    //查询用户总数
    @Override
    public int findTotal() {
        //打开一个会话工厂
        SqlSession session=factory.openSession();
        //查询用户单个文件
        Integer count =session.selectOne( "com.sanciyuan.Dao.UserDao.findTotal" );
        //关闭查询
        session.close();
        return count;
    }

    @Override
    public List<User> findUserByVo(QueryVo queryVo) {
        return null;
    }

}
