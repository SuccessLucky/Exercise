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

/**
 * Author：
 * Date：2019/9/29 9:37
 * Content：mybatis的CRUD增删改查操作
 */

public class SecondLevelCacheTest {

    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;

    //初始化方法
    @Before//用于测试方法执行之前执行
    public void init() throws Exception {
        //创建输入流对象
        inputStream = Resources.getResourceAsStream( "SqlMapConfig.xml" );
        //创建SqlSession的会话工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build( inputStream );
    }

    //关闭方法
    @After//用于测试方法执行之后执行
    public void destroy() throws Exception {
        inputStream.close();
    }

    //测试一级缓存
    @Test
    public void testFirstLevelCache() {
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        UserDao userDao1 = sqlSession1.getMapper( UserDao.class );
        User user1 = userDao1.UsernameByid( 41 );
        System.out.println( user1 );
        //关闭会话1
        sqlSession1.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        UserDao userDao2 = sqlSession2.getMapper( UserDao.class );
        User user2 = userDao2.UsernameByid( 41 );
        System.out.println( user2 );
        //关闭会话2
        sqlSession2.close();
        System.out.println( user1 == user2 );
    }

}
