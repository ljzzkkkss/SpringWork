package com.excelib.dao;

import com.excelib.bean.User;

/**
 * Created by 刘骏 on 2016/8/25.
 */
public interface UserDao {
    public User getUserByUsernameAndPassword(String username,String password);
}
