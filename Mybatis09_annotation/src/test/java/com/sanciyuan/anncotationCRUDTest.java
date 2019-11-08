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
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Author：
 * Date：2019/11/5 10:03
 * Content：
 */
public class anncotationCRUDTest {

    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private UserDao userDao;

    //初始化方法
    @Before
    public void init() throws IOException {
        inputStream= Resources.getResourceAsStream( "SqlMapConfig.xml" );
        sqlSessionFactory=new SqlSessionFactoryBuilder().build( inputStream );
        sqlSession=sqlSessionFactory.openSession();
        userDao = sqlSession.getMapper( UserDao.class );
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
        List<User> users = userDao.findAll();
        for (User user:users){
            System.out.println(user);
        }
    }

    //添加用户
    @Test
    public void testSave(){
        User user=new User();
        user.setUsername( "张三" );
        user.setBirthday(new Date( ));
        user.setSex( "男" );
        user.setAddress( "中国" );
        int save = userDao.Save( user );
        System.out.println(save+"行受影响");
    }

    //更新用户
    @Test
    public void testUpdate(){
        User user=new User();
        user.setId( 71 );
        user.setUsername( "小黄" );
        user.setBirthday( new Date(  ) );
        user.setSex( "女" );
        user.setAddress( "香港" );
        int update = userDao.update( user );
        System.out.println(update+"行受影响");
        System.out.println(new Date(  ));
    }

    //删除用户
    @Test
    public void testDelete(){
        int delete = userDao.Delete( 71 );
        System.out.println(delete+"受影响");
    }

    //根据Id进行查询
    @Test
    public void testfindById(){
        User byid = userDao.findByid( 71 );
        System.out.println(byid);
    }

    //根据姓名查询
    @Test
    public void testfindByName(){
        List<User> userByName = userDao.findUserByName( "小" );
        for (User user:userByName){
            System.out.println(user);
        }
    }

    //查询用户总数
    @Test
    public void testfindTotalUser(){
        int totalUser = userDao.findTotalUser();
        System.out.println(totalUser+"用户数据");
    }
}
