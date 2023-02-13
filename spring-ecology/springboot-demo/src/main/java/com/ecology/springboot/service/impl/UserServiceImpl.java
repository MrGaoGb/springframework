package com.ecology.springboot.service.impl;

import com.ecology.springboot.entity.User;
import com.ecology.springboot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.Gao
 * @date 2023/2/13 9:53
 * @apiNote:
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        User user1 = new User("陈金默", "123456", 18, "老默");
        User user2 = new User("高启强", "123789", 20, "阿强");
        list.add(user1);
        list.add(user2);
        return list;
    }
}
