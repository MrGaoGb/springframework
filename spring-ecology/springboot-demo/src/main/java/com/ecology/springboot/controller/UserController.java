package com.ecology.springboot.controller;

import com.ecology.springboot.entity.User;
import com.ecology.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Mr.Gao
 * @date 2023/2/13 9:43
 * @apiNote:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户信息
     *
     * @return
     */
    @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

}
