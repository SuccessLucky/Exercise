package com.sanciyuan.test;

import com.sanciyuan.Dao.UserDao;
import com.sanciyuan.Entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * Author：郭韫铭
 * Date：2019/9/26 15:06
 * Content：这是通过注解的形式配置Mybatis的文件
 */

public class mybatisTest {

    public static void main(String[] args) throws Exception {
        //创建输入流对象
        InputStream inputStream= Resources.getResourceAsStream( "SqlMapConfig.xml" );
        //创建SqlSession的会话工厂
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build( inputStream );
        //打开一个会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建Dao接口的对象
        UserDao userDao = sqlSession.getMapper( UserDao.class );
        //打开会话工厂
        List<User> users = userDao.findAll();
        //迭代遍历
        for (User user:users){
            System.out.println(user);
        }
        //释放资源
        sqlSession.close();
        inputStream.close();

    }
}
