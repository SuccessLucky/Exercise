package com.sanciyuan;

import com.sanciyuan.Dao.UserDao;
import com.sanciyuan.Entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Author：
 * Date：2019/9/29 9:37
 * Content：mybatis的CRUD增删改查操作
 */

public class UserTest {

    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private UserDao userDao;

    //初始化方法
    @Before//用于测试方法执行之前执行
    public void init() throws Exception {
        //创建输入流对象
        inputStream = Resources.getResourceAsStream( "SqlMapConfig.xml" );
        //创建SqlSession的会话工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build( inputStream );
        //打开一个会话
        sqlSession = sqlSessionFactory.openSession();
        //创建Dao接口的对象
        userDao = sqlSession.getMapper( UserDao.class );
    }

    //关闭方法
    @After//用于测试方法执行之后执行
    public void destroy() throws Exception {
        //提交事务
        sqlSession.commit();
        //关闭会话
        sqlSession.close();
        //关闭输入流对象
        inputStream.close();
    }

    //测试一级缓存
    @Test
    public void testFirstLevelCache() {
        User user = userDao.UsernameByid( 41 );
        System.out.println( user );
//        sqlSession.close();
//        sqlSession =sqlSessionFactory.openSession();
        //清空sqlSession的缓存
        sqlSession.clearCache();
        userDao = sqlSession.getMapper( UserDao.class );
        User user1 = userDao.UsernameByid( 41 );
        System.out.println( user1 );
        System.out.println( user == user1 );
    }

    //测试缓存的同步（二级缓存中存放的是数据不是对象）
    @Test
    public void testFirstLevelCache2() {
        //1,根据id查询用户
        User user = userDao.UsernameByid( 41 );
        System.out.println( user );
        //更新用户信息
        user.setUsername( "测试数据" );
        user.setAddress( "北京市海淀区" );
        userDao.updateUser( user );
        //再次查询id为41的用户
        User user2 = userDao.UsernameByid( 41 );
        System.out.println( user2 );
        System.out.println( user == user2 );
    }
}
