package com.series.demo.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Mr.Gao
 * @date: 2022年05月26日 16:57
 * @description:
 */
@Configuration
public class MainConfig7 {

    @Bean
    public String bean2() {
        return "bean2";
    }
}
