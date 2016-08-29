package com.excelib.dao;

import com.excelib.bean.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 刘骏 on 2016/8/25.
 */
@Component("userDao")
public class UserDao extends BaseDao{
    public List<User> getUserByPasswordAndUsername(String username, String password) {
        String sql = "select * from User where username='" + username + "' and password='" + password + "'";
        return super.query(sql,User.class);
    }

    public int updataUser(String username, String password, String newpassword) {
        String sql = "update User set password='" + newpassword + "' where username='" + username + "' and password='" + password + "'";
        return super.update(sql);
    }
}
