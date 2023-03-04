package com.ecology.springboot.service.impl;

import com.ecology.springboot.entity.User;
import com.ecology.springboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.Gao
 * @date 2023/2/17 14:36
 * @apiNote:
 * <p>
 * @RequiredArgsConstructor：表示通过构造方法的方式(动态)注入属性值，该方法可以更有效的提升应用启动性能（Spring官方推荐：构造方法注入属性）
 * @Autowired:表示根据类型并结合反射进行属性值的注入，
 * </p>
 */
@Service
@RequiredArgsConstructor
public class AccountService {

    private final UserService userService;
    public List<User> findAll() {
        return userService.findAll();
    }
}
