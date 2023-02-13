package com.ecology.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mr.Gao
 * @date 2023/2/13 9:44
 * @apiNote:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements java.io.Serializable {
    // 用户姓名
    private String userName;

    // 用户密码
    private String userPwd;

    // 年龄
    private Integer age;

    // 用户别名
    private String aliasName;
}
