package com.demo.controller;

import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.Gao
 * @date 2023/2/10 12:02
 * @apiNote:
 */
@RestController
public class UserController {

    @Autowired
    private RedissonClient redissonClient;


    @GetMapping("/userCount")
    public Integer getTotalUserCount() {
        return 1;
    }

}
