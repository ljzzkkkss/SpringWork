package com.excelib.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcOperations;

import javax.annotation.Resource;
import java.util.List;

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

    protected int update(String sql,Object... paramValue){
        return this.getJdbcTemplate().update(sql,paramValue);
    }

    protected int update(String namedSql, Object bean) {
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(
                bean);
        return this.getJdbcTemplate().update(namedSql,paramSource);
    }

    protected <T> T getBean(String sql, Class<T> T, Object... paramValue){
        RowMapper<T> rowMapper = new BeanPropertyRowMapper<T>(T);
        return this.getJdbcTemplate().queryForObject(sql,rowMapper,paramValue);
    }

    protected <T> List<T> query(String sql, Class<T> T, Object... paramValue){
        RowMapper<T> rowMapper = new BeanPropertyRowMapper<T>(T);
        return this.getJdbcTemplate().query(sql,rowMapper,paramValue);
    }

    protected void execute(String sql){
        this.getJdbcTemplate().execute(sql);
    }

}
