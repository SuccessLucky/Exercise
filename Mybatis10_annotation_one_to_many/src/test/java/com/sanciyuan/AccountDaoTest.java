package com.sanciyuan;

import com.sanciyuan.Dao.AccountDao;
import com.sanciyuan.Dao.UserDao;
import com.sanciyuan.Entity.Account;
import com.sanciyuan.Entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Author：
 * Date：2019/11/5 16:59
 * Content：
 */
public class AccountDaoTest {

    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private AccountDao accountDao;

    //初始化方法
    @Before
    public void init() throws IOException {
        inputStream= Resources.getResourceAsStream( "SqlMapConfig.xml" );
        sqlSessionFactory=new SqlSessionFactoryBuilder().build( inputStream );
        sqlSession=sqlSessionFactory.openSession();
        accountDao = sqlSession.getMapper( AccountDao.class );
    }

    //销毁方法
    @After
    public void destroy() throws IOException {
//        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    //查询所有人员信息
    @Test
    public void testfindAll(){
        List<Account> accountDaoAll = accountDao.findAll();
        for (Account account:accountDaoAll){
            System.out.println("-------每个账号的信息!-------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }
}
