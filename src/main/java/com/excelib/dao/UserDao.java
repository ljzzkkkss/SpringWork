package com.excelib.dao;

import com.excelib.bean.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 刘骏 on 2016/8/25.
 */
@Component("userDao")
public class UserDao extends BaseDao{
    public List<User> getUserByPasswordAndUsername(String username, String password) {
        String sql = "select * from User where username='" + username + "' and password='" + password + "'";
        return super.getJdbcTemplate().query(sql, new RowMapper() {
            public Object mapRow(ResultSet rs, int num) throws SQLException {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        });
    }
}
