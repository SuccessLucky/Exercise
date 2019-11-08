package com.sanciyuan;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.sanciyuan.Dao.UserDao;
import com.sanciyuan.Entity.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Author：
 * Date：2019/11/4 17:27
 * Content：
 */
public class anncotationTest {

    public static void main(String[] args) throws IOException {
        //1,获取字节输入流
        //2,根据字节输入流构建SqlSessionFactory
        //3,打开一个会话
        //4,使用SqlSession获取Dao接口的代理对象
        //5,执行Dao方法
        //6,释放资源

        InputStream inputStream = Resources.getResourceAsStream( "SqlMapConfig.xml" );
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build( inputStream );
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper( UserDao.class );
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();

    }



}
