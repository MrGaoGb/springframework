package com.demo.entity;

import lombok.Data;

/**
 * @author Mr.Gao
 * @date 2023/1/10 16:17
 * @apiNote:
 */
@Data
public class Person {

    // 用户姓名
    private String userName;

    // 用户密码
    private String userPwd;

    // 年龄
    private Integer age;

    // 用户别名
    private String aliasName;

}
