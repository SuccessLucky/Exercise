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
 * Date：2019/9/25 16:00
 * Content：mybatis中XML的测试类
 */

public class mybatisTest {

    public static void main(String[] args) throws Exception {
        //读取配置文件
        InputStream inputStream= Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory工厂
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build( inputStream );
        //使用工厂生产SqlSession对象
        SqlSession sqlSession=factory.openSession();
        //使用SqlSession创建Dao接口的代理对象
        UserDao userDao=sqlSession.getMapper( UserDao.class );
        //使用代理对象执行方法
        List<User> users=userDao.findAll();
        //循环遍历
        for (User user:users){
            System.out.println(user);
        }
        //释放资源
        sqlSession.close();
        inputStream.close();
    }
}
