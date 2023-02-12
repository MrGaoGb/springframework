package com.series.demo.test.value;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author: Mr.Gao
 * @date: 2022年06月30日 11:17
 * @description:
 */
@Component
@MrGaoScope
public class User {

    private String userName;

    public User() {
        System.out.println("create user obj...");
        this.userName = UUID.randomUUID().toString();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
