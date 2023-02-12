package com.series.demo.service;

import com.series.demo.service.autowired.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Map;

/**
 * @author: Mr.Gao
 * @date: 2022年05月26日 16:57
 * @description: @Scope作用域(单例或多例)
 */
@Configuration
public class MainConfig12 {

    /**
     * 实现IService接口
     *
     * @return
     */
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Service1 service1() {
        return new Service1();
    }

    /**
     * 实现IService接口
     *
     * @return
     */
    @Bean
    public Service0 service0() {
        return new Service0();
    }

    /**
     * Service2没有实现IService接口
     *
     * @return
     */
    @Bean
    public Service2 service2() {
        return new Service2();
    }

}
