package com.sanciyuan;

import com.sanciyuan.Dao.AccountDao;
import com.sanciyuan.Entity.Account;
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

public class AccountTest {

    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private AccountDao accountDao;

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
        accountDao = sqlSession.getMapper( AccountDao.class );
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

    //查询所有员工
    @Test
    public void testFindAll() {
        List<Account> accounts = accountDao.FindAccountAll();
        for (Account account : accounts) {
            System.out.println( account );
            System.out.println( account.getUser() );
        }
    }

}
