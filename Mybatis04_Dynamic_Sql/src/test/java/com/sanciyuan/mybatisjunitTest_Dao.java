package com.sanciyuan;

import com.sanciyuan.Dao.UserDao;
import com.sanciyuan.Entity.QueryVo;
import com.sanciyuan.Entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Author：
 * Date：2019/9/29 9:37
 * Content：mybatis的CRUD增删改查操作
 */

public class mybatisjunitTest_Dao {

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

    //保存员工方法(插入操作
    @Test
    public void testSave() {
        User user = new User();
        user.setUsername( "小梦" );
        user.setAddress( "上海市徐汇区" );
        user.setSex( "女" );
        //new Date()获取系统当前时间
        user.setBirthday( new Date() );
        System.out.println("保存之前:"+user);
        //调用插入
        userDao.saveUser( user );
        System.out.println( "一行受影响" );
        System.out.println("保存之后:"+user);
    }

    //更新数据
    @Test
    public void testUpdate() {
        User user = new User();
        user.setUserid( 58 );
        user.setUsername( "小刚" );
        user.setAddress( "北京市朝阳区" );
        user.setSex( "男" );
        //new Date()获取系统当前时间
        user.setBirthday( new Date() );
        //调用更新
        userDao.updateUser( user );
        System.out.println( "一行受影响" );
    }

    //删除指定用户
    @Test
    public void testDelete() {
        userDao.deleteUser( 68 );
        System.out.println( "一行受影响!" );
    }

    //根据id查询指定用户
    @Test
    public void testUsernameByid() {
        User user = userDao.UsernameByid( 41 );
        System.out.println( user );
    }

    //根据用户名进行模糊查询
    @Test
    public void testUsernamebydim() {
        String placeholder1 = "%";
        String placeholder2 = "%";
//        List<User> userdim = userDao.Usernamebydim( placeholder1 + "小" + placeholder2 );
        List<User> userdim = userDao.Usernamebydim("马");
        for (User user : userdim) {
            System.out.println( user );
        }
    }

    //根据id查询总记录数
    @Test
    public void testFindTotal() {
        int count = userDao.findTotal();
        System.out.println( "查询总记录数：" + count + "条" );
    }

    //通过另QueryVo实体对象进行用户名的模糊查询
    @Test
    public void testFindByVo() {
        String placeholder1 = "%";
        String placeholder2 = "%";
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername( placeholder1 + "王" + placeholder2 );
        //把User的set参数对象传递给queryVo对象
        queryVo.setUser( user );
        //调用方法的参数
        List<User> userByVo1 = userDao.findUserByVo( queryVo );
        //迭代遍历
        for (User user1 : userByVo1) {
            System.out.println( "取值：" + user1 );
        }
    }

    //测试根据传入参数进行查询
    @Test
    public void testfindUserByCondition(){
        User user=new User();
        user.setUsername("老王");
        user.setSex( "女" );
        //5,执行查询所有方法
        List<User> users=userDao.findUserByCondition( user );
        for (User users1:users){
            System.out.println(users1);
        }
    }

    @Test
    public void testfindUserInIds(){
        QueryVo vo=new QueryVo();
        List<Integer> list=new ArrayList<Integer>(  );
        list.add( 41 );
        list.add( 42 );
        list.add( 46 );
        vo.setIds( list );
        List<User> userInIds = userDao.findUserInIds(vo);
        for (User user:userInIds){
            System.out.println(user);
        }
    }
}
