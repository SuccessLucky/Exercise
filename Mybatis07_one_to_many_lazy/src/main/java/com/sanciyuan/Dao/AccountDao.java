package com.sanciyuan.Dao;

import com.sanciyuan.Entity.Account;

import java.util.List;

/**
 * Author：
 * Date：2019/10/30 12:00
 * Content：一对多的映射查询
 */
public interface AccountDao {

    //查询所有账号
    List<Account> FindAccountAll();

}
