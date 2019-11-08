package com.sanciyuan.Entity;


import java.io.Serializable;

/**
 * Author：
 * Date：2019/11/5 16:44
 * Content：账户信息
 */
public class Account implements Serializable {

    private int id;
    private int uid;
    private Double money;

    //多对一的对应关系(mybatis中称之为)的映射:
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                '}';
    }

}
