package com.excelib.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by 刘骏 on 2016/8/25.
 */
@Component
public class User implements Serializable {
    public String id;
    public String username;
    public String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
