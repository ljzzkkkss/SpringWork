package com.excelib.Service;

import com.excelib.bean.User;
import com.excelib.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 刘骏 on 2016/8/28.
 */
@Service("userService")
public class UserService {
    @Resource
    private UserDao userDao;

    public List<User> getUserByPasswordAndUsername (String username, String password){
        return userDao.getUserByPasswordAndUsername(username,password);
    }

    public int updateUser(String username, String password, String newpassword){
        return userDao.updataUser(username,password,newpassword);
    }
}
