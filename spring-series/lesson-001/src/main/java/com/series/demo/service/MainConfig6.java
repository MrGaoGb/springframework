package com.series.demo.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author: Mr.Gao
 * @date: 2022年05月26日 16:57
 * @description:
 */
@Configuration
public class MainConfig6 {

    @Bean
    public String bean1() {
        return "bean1";
    }
}
