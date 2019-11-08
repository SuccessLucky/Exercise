package com.sanciyuan.Entity;

/**
 * Author：
 * Date：2019/10/30 16:23
 * Content：账号对应的用户信息
 */
public class AccountUser extends Account {

    private String username;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        //这里的super.toString()为父类中的toString方法
        return super.toString()+"       AccountUser{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
