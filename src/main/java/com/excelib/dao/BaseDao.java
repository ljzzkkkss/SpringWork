package com.excelib.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;

/**
 * Created by 刘骏 on 2016/8/28.
 */
public class BaseDao {
    private JdbcTemplate jdbcTemplate;


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Resource
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
