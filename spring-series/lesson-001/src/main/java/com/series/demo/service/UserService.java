package com.series.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: Mr.Gao
 * @date: 2022年06月21日 10:43
 * @description:
 */
public class UserService {

    @Autowired
    private AccountService accountService;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserService{");
        sb.append("accountService=").append(accountService);
        sb.append('}');
        return sb.toString();
    }
}
