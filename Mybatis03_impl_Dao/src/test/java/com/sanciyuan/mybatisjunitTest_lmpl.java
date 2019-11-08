package com.sanciyuan;

import com.sanciyuan.Dao.UserDao;
import com.sanciyuan.Entity.User;
import com.sanciyuan.Impl.UserDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Author：
 * Date：2019/9/29 9:37
 * Content：mybatis的CRUD增删改查操作
 */

public class mybatisjunitTest_lmpl {

    private InputStream inputStream;
    private SqlSession sqlSession;
    private SqlSessionFactory sqlSessionFactory;
    private UserDao userDao;

    //初始化方法
    @Before//用于测试方法执行之前执行
    public void init() throws Exception {
        //创建输入流对象
        inputStream = Resources.getResourceAsStream( "SqlMapConfig.xml" );
        //创建SqlSession的会话工厂
         sqlSessionFactory = new SqlSessionFactoryBuilder().build( inputStream );
        //创建Dao接口的对象
        userDao = new UserDaoImpl( sqlSessionFactory );
    }

    //关闭方法
    @After//用于测试方法执行之后执行
    public void destroy() throws IOException {
//        //提交事务
//        sqlSession.commit();
        //关闭会话
//        sqlSession.close();
        //关闭输入流对象
        inputStream.close();

    }

    //查询所有员工
    @Test
    public void TestFindAll() throws Exception {
        //打开会话工厂
        List<User> users = userDao.findAll();
        //迭代遍历
        for (User user : users) {
            System.out.println( user );
        }
    }

    //保存用户
    @Test
    public void testSave() {
        User user = new User();
        user.setUsername( "小明" );
        user.setAddress( "河南省周口市" );
        user.setSex( "男" );
        user.setBirthday( new Date() );
        System.out.println( "保存之前:" + user );
        userDao.saveUser( user );
        System.out.println( "一行受影响" );
        System.out.println( "保存之后:" + user );
    }

    //更新用户
    @Test
    public void testupdate() {
        User user = new User();
        user.setId( 48 );
        user.setUsername( "小马" );
        user.setAddress( "北京市朝阳区" );
        user.setSex( "女" );
        user.setBirthday( new Date() );
        userDao.updateUser( user );
    }

    //删除用户
    @Test
    public void testdelete() {
        userDao.deleteUser( 70 );
    }

    //根据id查询指定用户
    @Test
    public void testUsernameByid() {
        User user = userDao.UsernameByid( 60 );
        System.out.println( user );
    }

    //根据姓名查询指定用户
    @Test
    public void testUsernamebydim() {
        List<User> users = userDao.Usernamebydim( "王" );
        for (User user : users) {
            System.out.println( user );
        }
    }

    //获取用户的总记录数
    @Test
    public void testfindTotal() {
        int total = userDao.findTotal();
        //打开会话工厂
        List<User> users = userDao.findAll();
        //迭代遍历
        for (User user : users) {
            System.out.println( user );
        }
        System.out.println( "共" + total + "条数据" );
    }
}
