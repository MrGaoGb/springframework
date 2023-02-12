package com.series.demo.test.value;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Mr.Gao
 * @date: 2022年06月29日 16:50
 * @description:
 */
@Getter
@Setter
@ToString
@Configuration
public class DbConfig {

    /**
     * 用户名
     */
    @Value("${jdbc.username}")
    private String username;
    /**
     * 密码
     */
    @Value("${jdbc.password}")
    private String password;
    /**
     * 连接URL
     */
    @Value("${jdbc.url}")
    private String url;

}
