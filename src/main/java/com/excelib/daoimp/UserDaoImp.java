package com.excelib.daoimp;

import com.excelib.bean.User;
import com.excelib.dao.UserDao;
import com.excelib.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

/**
 * Created by LiuJun on 2016/8/26.
 */
public class UserDaoImp implements UserDao{
    @Override
    public User getUserByUsernameAndPassword (String username,String password){
        //获得会话对象
        SqlSession session = MyBatisUtil.getSession();
        try {
            //通过MyBatis实现接口BookTypeDAO，返回实例
            UserDao userDao=session.getMapper(UserDao.class);
            return userDao.getUserByUsernameAndPassword(username, password);
        } finally {
            session.close();
        }
    }
}
