package com.ecology.springboot.service;

import com.ecology.springboot.entity.User;

import java.util.List;

/**
 * @author Mr.Gao
 * @date 2023/2/13 9:52
 * @apiNote:
 */
public interface UserService {

    /**
     * 获取所有学生
     *
     * @return
     */
    List<User> findAll();
}
