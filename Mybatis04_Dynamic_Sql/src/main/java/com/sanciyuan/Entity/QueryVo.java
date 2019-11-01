package com.sanciyuan.Entity;

import java.util.List;

/**
 * Author：
 * Date：2019/9/29 17:24
 * Content：封装的查询对象
 */
public class QueryVo {

    private User user;

    private List<Integer> ids;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
