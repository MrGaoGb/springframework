package com.series.demo.config;

import com.series.demo.entity.UserModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Mr.Gao
 * @date: 2022年05月25日 16:39
 * @description:
 */
@Configuration
public class ConfigurationBean {

    @Bean
    public UserModel userModel() {
        return new UserModel();
    }

    @Bean("userModel2")
    public UserModel userModel2() {
        return new UserModel();
    }

    @Bean(value = {"userModel3", "userModelAlias1", "userModelAlias2"})
    public UserModel userModel3() {
        return new UserModel();
    }
}
